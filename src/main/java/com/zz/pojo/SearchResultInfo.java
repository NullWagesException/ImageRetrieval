package com.zz.pojo;


//检索返回值
public class SearchResultInfo {

    private String log_id;
    private String cont_sign;
    private String error_msg;
    private String error_code;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getCont_sign() {
        return cont_sign;
    }

    public void setCont_sign(String cont_sign) {
        this.cont_sign = cont_sign;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

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
