package com.zz.pojo;

import java.util.Date;

public class User {

    private Integer id;
    //用户唯一标识
    private String phoneid;
    private Date createtime;
    private String localtion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneid='" + phoneid + '\'' +
                ", createtime=" + createtime +
                ", localtion='" + localtion + '\'' +
                '}';
    }
}
