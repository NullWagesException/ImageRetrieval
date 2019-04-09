package com.zz.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 检索数组中图片信息
 */
@Getter
@Setter
public class SearchImgInfo {

    //返回唯一ID
    private String log_id;
    //是否分页
    private boolean has_more;
    //返回的数量
    private Integer result_num;
    //每条数据信息
    private List<SearchInfo> result;

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
