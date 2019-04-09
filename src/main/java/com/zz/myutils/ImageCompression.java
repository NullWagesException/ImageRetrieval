package com.zz.myutils;


import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

//图片压缩
public class ImageCompression {

    /**
     * 调用方法对图片进行压缩处理，同时覆盖原文件
     *
     * @param filepath 文件路径
     * @throws IOException
     */
    public static void Compression(String filepath) throws IOException {
        Thumbnails.of(filepath)
                //图片的大小
                .scale(1f)
                //图片的质量
                .outputQuality(0.5f)
                .toFile(filepath);
    }

    public static void main(String[] args) {
        try {
            Compression("C:\\Users\\62400\\Pictures\\IMG_20190406_190617.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
