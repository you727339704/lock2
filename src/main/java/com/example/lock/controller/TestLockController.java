package com.example.lock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 类描述 <p>
 * Copyright: Copyright © 2019 ECARX Co., Ltd. All Rights Reserved. <p>
 * Company: 湖北亿咖通科技有限公司<p>
 *
 * @author yuntao.jiang
 * @since 2019/9/18 10:46
 */
@RestController
@Slf4j
public class TestLockController {

    RedisController jedisCom = new RedisController();


    //总库存
    private long nKuCuen = 0;
    //商品key名字
    private String shangpingKey = "computer_key";
    //获取锁的超时时间 秒
    private int timeout = 30 * 1000;

    @GetMapping("/qiangdan")
    public List<String> qiangdan() {


        //抢到商品的用户
        List<String> shopUsers = new ArrayList<>();

        //构造很多用户  需要注意 不能使用ArrayList  下边并行流创建用户会造成线程安全问题
        List<String> users = new Vector<>(100001);
        /*List<Integer> users2 = new ArrayList<>(10000001);
        List<Integer> integerList = Collections.synchronizedList(users2);*/
        long l = System.currentTimeMillis();

            IntStream.range(0, 100000).parallel().forEach(b -> {
                System.out.println(b);
                users.add("云涛-" + b);
        });
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);

        //初始化库存
        nKuCuen = 10;

        //模拟开抢
        users.parallelStream().forEach(b -> {
            String shopUser = qiang(b);
            if (!StringUtils.isEmpty(shopUser)) {
                shopUsers.add(shopUser);
            }
        });

        return shopUsers;
    }

    /**
     * 模拟抢单动作
     *
     * @param b
     * @return
     */
    private String qiang(String b) {
        //用户开抢时间
        long startTime = System.currentTimeMillis();

        //未抢到的情况下，30秒内继续获取锁
        while ((startTime + timeout) >= System.currentTimeMillis()) {
            //商品是否剩余
            if (nKuCuen <= 0) {
                break;
            }
            if (jedisCom.setnx(shangpingKey, b)) {
                //用户b拿到锁
                log.info("用户{}拿到锁...", b);
                try {
                    //商品是否剩余
                    if (nKuCuen <= 0) {
                        break;
                    }

                    //模拟生成订单耗时操作，方便查看：云涛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //抢购成功，商品递减，记录用户
                    nKuCuen -= 1;

                    //抢单成功跳出
                    log.info("用户{}抢单成功跳出...所剩库存：{}", b, nKuCuen);

                    return b + "抢单成功，所剩库存：" + nKuCuen;
                } finally {
                    log.info("用户{}释放锁...", b);
                    //模拟退单  用户名字中带3的自动退单
                    if(b.contains("3")){
                        log.info("用户{}退单...",b);
                        //退单之后加库存
                        nKuCuen+=1;
                        log.info("用户{}退单单成功跳出...所剩库存：{}", b, nKuCuen);
                    }
                    //释放锁
                   Integer c =  jedisCom.delnx(shangpingKey, b);
                    System.out.println(c);

                }
            } else {
                //用户b没拿到锁，在超时范围内继续请求锁，不需要处理
               if (b.equals("云涛-50") || b.equals("云涛-69")) {
                    log.info("用户{}等待获取锁...", b);
               }
            }
        }
        return "";
    }
}
