package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {

    private Integer id;
    //用户唯一标识
    private String phoneid;
    private Date createtime;
    private String localtion;

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
