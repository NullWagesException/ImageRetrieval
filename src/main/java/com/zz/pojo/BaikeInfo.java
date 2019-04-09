package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

//百度百科词条
@Getter
@Setter
public class BaikeInfo {

    private String baike_url;
    private String image_url;
    private String description;

    @Override
    public String toString() {
        return "ParsingInfo{" +
                "baike_url='" + baike_url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
