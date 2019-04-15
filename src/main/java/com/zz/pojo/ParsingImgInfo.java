package com.zz.pojo;

import java.util.List;

public class ParsingImgInfo {

    private String log_id;
    private String result_num;
    private List<ParsingInfo> result;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getResult_num() {
        return result_num;
    }

    public void setResult_num(String result_num) {
        this.result_num = result_num;
    }

    public List<ParsingInfo> getResult() {
        return result;
    }

    public void setResult(List<ParsingInfo> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ParsingImgInfo{" +
                "log_id='" + log_id + '\'' +
                ", result_num='" + result_num + '\'' +
                ", result=" + result +
                '}';
    }
}
