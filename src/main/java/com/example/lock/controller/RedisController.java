package com.example.lock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 类描述 <p>
 * Copyright: Copyright © 2019 ECARX Co., Ltd. All Rights Reserved. <p>
 * Company: 湖北亿咖通科技有限公司<p>aaaaaaa
 *
 * @author yuntao.jiang
 * @since 2019/9/5 18:19
 */
@RestController
public class RedisController {

    JedisPool jedisPool = new JedisPool();


    /**
     * 加锁
     * @param key
     * @param val
     * @return abc
     */
    public boolean setnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return false;
            }

            return jedis.set(key, val, "NX", "PX", 1000 * 60).
                    equalsIgnoreCase("ok");
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    @GetMapping("/setnx/{key}/{val}")//22222222222222222222222222222222
    public boolean setnx2(@PathVariable String key, @PathVariable String val) {
        return setnx(key, val);
    }


    /**
     * 释放锁
     * @param key
     * @param val
     * @return
     */
    public int delnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return 0;
            }

            StringBuilder sbScript = new StringBuilder();
            sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").
                    append(" then ").
                    append("    return redis.call('del','").append(key).append("')").
                    append(" else ").
                    append("    return 0").
                    append(" end");

            return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

    @GetMapping("/delnx/{key}/{val}")
    public int delnx2(@PathVariable String key, @PathVariable String val) {
        return delnx(key, val);
    }

}
