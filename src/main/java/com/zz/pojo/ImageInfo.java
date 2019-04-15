package com.zz.pojo;

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

    public long getImageid() {
        return imageid;
    }

    public void setImageid(long imageid) {
        this.imageid = imageid;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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
