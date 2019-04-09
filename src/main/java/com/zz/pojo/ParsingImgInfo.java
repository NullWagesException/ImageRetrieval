package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParsingImgInfo {

    private String log_id;
    private String result_num;
    private List<ParsingInfo> result;

    @Override
    public String toString() {
        return "ParsingImgInfo{" +
                "log_id='" + log_id + '\'' +
                ", result_num='" + result_num + '\'' +
                ", result=" + result +
                '}';
    }
}
