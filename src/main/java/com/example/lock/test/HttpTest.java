package com.example.lock.test;

import com.alibaba.fastjson.JSONObject;
import com.example.lock.util.HttpUtil;
import com.example.lock.vo.AmapPoisVO;
import com.example.lock.vo.AmapSuggestionVO;
import com.example.lock.vo.AmapVO;

import java.util.List;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/11/1 10:52
 */
public class HttpTest {
    public static void main(String[] args){
        //接口地址
        String url = "https://restapi.amap.com/v3/place/text?key=60c964d9f4a5004205e74f16f180ec08&keywords=北京八维研修学院";
        String s = HttpUtil.doGet(url);
        System.out.println(s);
        AmapVO amapVO =  JSONObject.parseObject(s,AmapVO.class);
        String info = amapVO.getInfo();
        System.out.println(info);
        AmapSuggestionVO suggestion = amapVO.getSuggestion();
        List<String> cities = suggestion.getCities();
        cities.forEach(
                i->{
                    System.out.println(i);
                }
        );






















        cities.forEach(i->{
            System.out.println(i);
        });

        List<AmapPoisVO> pois = amapVO.getPois();
        pois.forEach(
                j->{
                    System.out.println(j.getName());
                }
        );















        pois.forEach(i->{
           System.out.println(i.getId());
           System.out.println(i.getName());
        });

        // JSONObject.parseObject()

    }
}
