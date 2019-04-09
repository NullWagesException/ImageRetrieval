package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * 检索返回JSON数组信息
 */
@Getter
@Setter
public class SearchInfo {

    //存入图片时备注存入的信息
    private String brief;
    //相似度
    private Double score;
    private String cont_sign;

    @Override
    public String toString() {
        return "SearchInfo{" +
                "brief='" + brief + '\'' +
                ", score=" + score +
                ", cont_sign='" + cont_sign + '\'' +
                '}';
    }


}
