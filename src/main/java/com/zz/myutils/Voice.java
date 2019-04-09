package com.zz.myutils;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

//调用百度云API将文字转为语音
public class Voice {

    public static void synthesis(String desc) throws IOException {

        AipSpeech client = AipImageClassifyClient.getAipSpeech();
        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        TtsResponse res = client.synthesis(desc, "zh", 1, options);
        JSONObject result = res.getResult();    //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        byte[] data = res.getData();            //生成的音频数据
        System.out.println(data.length);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("D:\\KDR\\voice.mp3");
            outputStream.write(data);
            outputStream.close();
        }finally {
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            synthesis("hahahahha");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
