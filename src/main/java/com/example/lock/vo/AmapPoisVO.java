package com.example.lock.vo;

import lombok.Data;

import java.util.List;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/11/1 15:06
 */
@Data
public class AmapPoisVO {
    String id;
    List<String> parent;
    List<String> childtype;
    String name;
    String type;
    String typecode;
    List<String> biz_type;
    String address;
    String location;
    String tel;
    List<String> distance;
    AmapPoisBizExtVO biz_ext;
    String pname;
    String cityname;
    String  adname;
    List<String> importance;
    List<String> shopid;
    String shopinfo;
    List<String> poiweight;
    List<AmapPoisPhotosVO> photos;






}
