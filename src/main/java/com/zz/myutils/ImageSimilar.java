package com.zz.myutils;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.imagesearch.AipImageSearch;
import com.zz.pojo.SearchImgInfo;
import com.zz.pojo.SearchInfo;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 相似图检索工具类
 */
public class ImageSimilar {

    private ImageSimilar(){}
    //相似图检索—入库
    public static String add(byte[] bytes,String name,long id) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("brief", "{\"name\":\""+ name + "\", \"id\":\"" + id + "\"}");

        AipImageSearch client = AipImageClassifyClient.getImageSearch();
        // 参数为二进制数组
        JSONObject res = client.similarAdd(bytes, options);
        System.out.println(res.toString());
        return res.toString();

    }

    public static Map<String,Double> search(String path) {
        Map<String,Double> resultmap = new HashMap<>();
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("pn", "1000");

        AipImageSearch client = AipImageClassifyClient.getImageSearch();
        // 参数为本地路径

        JSONObject res = client.similarSearch(path, options);
        String str = res.toString();
        System.out.println(str);
        SearchImgInfo searchImgInfo = JSON.parseObject(str, SearchImgInfo.class);
        System.out.println(searchImgInfo);
        List<SearchInfo> result = searchImgInfo.getResult();
        Collections.sort(result, new Comparator<SearchInfo>() {
            @Override
            public int compare(SearchInfo o1, SearchInfo o2) {
                if(o1.getScore() > o2.getScore()) {
                    //return -1:即为正序排序
                    return -1;
                }else if (o1.getScore() == o2.getScore()) {
                    return 0;
                }else {
                    //return 1: 即为倒序排序
                    return 1;
                }
            }
        });

        for (SearchInfo searchInfo : result) {
            System.out.println("比例:" + searchInfo);
        }

        DecimalFormat format = new DecimalFormat("0.00");
        if (result.size() >10){
            int index = 0;
            while (index++ < 10){
                String id = getid(result.get(index).getBrief());
                resultmap.put(id,Double.parseDouble(format.format(result.get(index).getScore())));
            }
        }else{
            for (SearchInfo searchInfo : result) {
                String id = getid(searchInfo.getBrief());
                resultmap.put(id,Double.parseDouble(format.format(searchInfo.getScore())));
            }
        }

        System.out.println(resultmap.size());
        for (Map.Entry<String, Double> entry : resultmap.entrySet()) {
            System.out.println(entry.getKey() + ":"  + entry.getValue());
        }
        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = client.similarSearch(file, options);
//        System.out.println(res.toString(2));

        return resultmap;
    }

    private static String getid(String brief){
        String[] split = brief.split(":");
        String ID = split[split.length-1];
        return ID.substring(1,ID.length()-2);

    }

    public static void main(String[] args) {
        ImageSimilar similar = new ImageSimilar();
        ImageSimilar.search("D:\\KDR\\建筑-其他\\3928437457377725574IMG_20190406_190617.jpg");
    }

}
