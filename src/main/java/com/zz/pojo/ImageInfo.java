package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageInfo {

    //图片唯一ID
    private long imageid;
    //置信度
    private Double score;
    //分类
    private String root;
    //关键字
    private String keyword;
    //百度百科描述
    private String description;

    private String uid;
    //图片路径
    private String path;


    @Override
    public String toString() {
        return "ImageInfo{" +
                "imageid='" + imageid + '\'' +
                ", score=" + score +
                ", root='" + root + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", uid=" + uid +
                ", path='" + path + '\'' +
                '}';
    }
}
