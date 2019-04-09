package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片识别后的详细描述信息
 */
@Setter
@Getter
public class ParsingInfo {

    private Double score;
    private String root;
    private String keyword;
    private BaikeInfo baikeInfo;

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
