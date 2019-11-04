package com.example.lock.vo;

import lombok.Data;

import java.util.List;

/**
 *
 * 高德VO
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/11/1 14:55
 */

@Data
public class AmapVO {

    String status;
    String count;
    String info;
    String infocode;
    AmapSuggestionVO suggestion;
    List<AmapPoisVO> pois;

}
