package com.zz.pojo;

import java.util.List;

/**
 * 检索数组中图片信息
 */
public class SearchImgInfo {

    //返回唯一ID
    private String log_id;
    //是否分页
    private boolean has_more;
    //返回的数量
    private Integer result_num;
    //每条数据信息
    private List<SearchInfo> result;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public Integer getResult_num() {
        return result_num;
    }

    public void setResult_num(Integer result_num) {
        this.result_num = result_num;
    }

    public List<SearchInfo> getResult() {
        return result;
    }

    public void setResult(List<SearchInfo> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SearchImgInfo{" +
                "log_id='" + log_id + '\'' +
                ", has_more=" + has_more +
                ", result_num=" + result_num +
                ", result=" + result +
                '}';
    }
}
