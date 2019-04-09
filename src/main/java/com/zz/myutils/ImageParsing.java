package com.zz.myutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.zz.pojo.ImageInfo;
import com.zz.pojo.ParsingImgInfo;
import com.zz.pojo.ParsingInfo;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class ImageParsing {

    private ImageParsing(){}

    /**
     * 传入一张图片，返回该图片识别置信度、分类、关键字、详细信息
     * @param path 本地图片路径
     */
    public static ImageInfo Distinguish(String path) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "1");
        options.put("result_num","1");

        AipImageClassify client = AipImageClassifyClient.getImageClassify();
        // 参数为本地路径
        JSONObject res = client.advancedGeneral(path, options);
        System.out.println(res.toString());
        System.out.println();
        //将json字符串转为可解析对象
        ParsingImgInfo imgInfo = JSON.parseObject(res.toString(), ParsingImgInfo.class);
        return getimageinfo(imgInfo);
    }

    /**
     * 传入一张图片，返回该图片识别置信度、分类、关键字、详细信息
     * @param bytes 二进制数组
     */
    public static ImageInfo Distinguish(byte[] bytes) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "1");

        AipImageClassify client = AipImageClassifyClient.getImageClassify();
        // 参数为本地路径
        JSONObject res = client.advancedGeneral(bytes, options);
        System.out.println(res.toString());
        //将json字符串转为可解析对象
        ParsingImgInfo imgInfo = JSON.parseObject(res.toString(), ParsingImgInfo.class);

        return getimageinfo(imgInfo);

    }

    private static ImageInfo getimageinfo(ParsingImgInfo imgInfo){
        ImageInfo imageInfo = new ImageInfo();
        //获取唯一ID
        imageInfo.setImageid(new BigDecimal(imgInfo.getLog_id()).longValue());
        //设置相关属性
        List<ParsingInfo> result = imgInfo.getResult();
        for (ParsingInfo parsingInfo : result) {
            System.out.println(parsingInfo.getBaikeInfo());
            if (null != parsingInfo.getBaikeInfo()){
                setimageInfo(parsingInfo,imageInfo);
            }
        }
        //如果没有百度百科数据
        if (null == imageInfo.getDescription()){
            imageInfo.setDescription("暂无描述");
        }
        return imageInfo;
    }

    private static void setimageInfo(ParsingInfo parsingInfo,ImageInfo imageInfo){
        imageInfo.setKeyword(parsingInfo.getKeyword());
        imageInfo.setRoot(parsingInfo.getRoot());
        imageInfo.setScore(parsingInfo.getScore());
        imageInfo.setDescription(parsingInfo.getBaikeInfo().getDescription());
    }

    public static void main(String[] args) {
        ImageParsing parsing = new ImageParsing();
        parsing.Distinguish("D:\\KDR\\人物-人物特写\\3131020741947250820z17.jpg");
    }
}
