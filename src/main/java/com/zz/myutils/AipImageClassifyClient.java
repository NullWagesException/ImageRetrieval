package com.zz.myutils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.imagesearch.AipImageSearch;
import com.baidu.aip.speech.AipSpeech;


public class AipImageClassifyClient {

    //图像识别client
    private static AipImageClassify imageClassify;
    //图像检索client
    private static AipImageSearch imageSearch;
    //语音合成client
    private static AipSpeech aipSpeech;

    //设置APPID/AK/SK
    public static final String APP_ID = "15914608";
    public static final String API_KEY = "3mz4iP7phVyXxdI3iVDnAoL1";
    public static final String SECRET_KEY = "DVA7tYBBtL8fsAhD1wubtQZBwywGICgn";

    static{
        imageClassify = new AipImageClassify(APP_ID,API_KEY,SECRET_KEY);
        imageSearch = new AipImageSearch(APP_ID,API_KEY,SECRET_KEY);
        aipSpeech = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    }

    private AipImageClassifyClient(){}

    public static AipImageClassify getImageClassify(){
        return imageClassify;
    }

    public static AipImageSearch getImageSearch() {
        return imageSearch;
    }

    public static AipSpeech getAipSpeech() {
        return aipSpeech;
    }
}
