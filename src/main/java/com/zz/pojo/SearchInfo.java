package com.zz.pojo;


/**
 * 检索返回JSON数组信息
 */
public class SearchInfo {

    //存入图片时备注存入的信息
    private String brief;
    //相似度
    private Double score;
    private String cont_sign;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCont_sign() {
        return cont_sign;
    }

    public void setCont_sign(String cont_sign) {
        this.cont_sign = cont_sign;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "brief='" + brief + '\'' +
                ", score=" + score +
                ", cont_sign='" + cont_sign + '\'' +
                '}';
    }


}
