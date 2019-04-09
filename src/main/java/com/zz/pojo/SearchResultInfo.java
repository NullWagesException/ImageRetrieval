package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

//检索返回值
@Getter
@Setter
public class SearchResultInfo {

    private String log_id;
    private String cont_sign;
    private String error_msg;
    private String error_code;

    @Override
    public String toString() {
        return "SearchResultInfo{" +
                "log_id='" + log_id + '\'' +
                ", cont_sign='" + cont_sign + '\'' +
                ", error_msg='" + error_msg + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
