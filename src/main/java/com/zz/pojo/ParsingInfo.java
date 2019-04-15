package com.zz.pojo;


/**
 * 图片识别后的详细描述信息
 */
public class ParsingInfo {

    private Double score;
    private String root;
    private String keyword;
    private BaikeInfo baikeInfo;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public BaikeInfo getBaikeInfo() {
        return baikeInfo;
    }

    public void setBaikeInfo(BaikeInfo baikeInfo) {
        this.baikeInfo = baikeInfo;
    }

    @Override
    public String toString() {
        return "ParsingInfo{" +
                "score=" + score +
                ", root='" + root + '\'' +
                ", keyword='" + keyword + '\'' +
                ", baikeInfo=" + baikeInfo +
                '}';
    }
}
