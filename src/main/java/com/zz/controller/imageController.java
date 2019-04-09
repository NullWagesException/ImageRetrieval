package com.zz.controller;

import com.alibaba.fastjson.JSON;
import com.zz.myutils.*;
import com.zz.pojo.ImageInfo;
import com.zz.pojo.SearchResultInfo;
import com.zz.pojo.User;
import com.zz.service.IimageService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import static com.zz.myutils.Voice.synthesis;

@RequestMapping("image")
@Controller
public class imageController {

    @Getter
    @Setter
    @Autowired
    private IimageService imageService;

    //上传图片id
    private long imageid;

    //原图片路径
    private String rootPath;

    //用户位置信息
    private String localtion;
//    //相似图片1
//    private String searchPath_1;
//    //相似图片2
//    private String searchPath_2;
//    //相似图片3
//    private String searchPath_3;
//    //相似图片4
//    private String searchPath_4;
//    //相似图片5
//    private String searchPath_5;

    //完成图像识别，存入云图库,获取语音解释和数据库功能
    @RequestMapping(value = "/uploadsignimg", method = RequestMethod.POST)
    public ModelAndView uploadOrderSignImage(MultipartFile file, HttpServletRequest request) throws IOException {

        ModelAndView mv = new ModelAndView();
        ImageInfo imageInfo = ImageParsing.Distinguish(file.getBytes());
        ImageSave.savedir(file,imageInfo);
        //如果保存成功
        User user = new User();
        String ipAddr = GetAddrIp.getIpAddr(request);
        user.setPhoneid(ipAddr);
        user.setCreatetime(new Date());
        user.setLocaltion(localtion);
        //存入数据库
        imageService.addImage(imageInfo,user);
        //将图片上传到百度云图库
        String add = ImageSimilar.add(file.getBytes(), imageInfo.getKeyword(), imageInfo.getImageid());
        //返回信息
        SearchResultInfo info = JSON.parseObject(add, SearchResultInfo.class);
        //获取语音解释
        synthesis(imageInfo.getDescription());
        //Imapath
        imageid = imageInfo.getImageid();
//        if (imageid == null){
//            mv.addObject("errormessage","图片地址无效！");
//            mv.setViewName("/error.jsp");
//            return mv;
//        }
        mv.setViewName("forward:/image/serchImage");
        //发现百度云图库中已存在图片时，返回错误信息，并删除已存入本地的图片
//      File file1 = new File(imageInfo.getPath());
//      file1.delete();
        return mv;
    }

    //从云图库完成相似图像检索，并获取对应信息，将本地图片读取
    @RequestMapping("/serchImage")
    public ModelAndView serchImage() throws IOException {
        ModelAndView mv = new ModelAndView("/result.jsp");

        ImageInfo image = imageService.getImage(imageid);
        //设置关键字
        mv.addObject("keyword",image.getKeyword());

        //设置描述信息
        mv.addObject("desc",image.getDescription());
        //加载语音信息

        //设置图片路径
        rootPath = image.getPath().split("KDR")[1];
        mv.addObject("rootPath",rootPath);
        System.out.println(rootPath);

        Map<String, Double> searchmap = ImageSimilar.search(image.getPath());

        addAttr(searchmap,image,mv);

        return mv;
    }

    //获取位置信息
    @RequestMapping("getLocaltion/{attr}")
    public void getLocaltion(@PathVariable("attr") String attr){
//        User user = userService.findUserById(id);
        localtion = attr;
    }

    //将查询到的图片信息进行感知哈希算法匹配后装载
    private void addAttr(Map<String, Double> searchmap,ImageInfo rootimage,ModelAndView mv){
        List<ImageInfo> infoList = new ArrayList<>();

        for (Map.Entry<String, Double> entry : searchmap.entrySet()) {
            ImageInfo image = imageService.getImage(new BigDecimal(entry.getKey()).longValue());
            if (image != null){
                image.setScore(entry.getValue());
                infoList.add(image);
            }
        }

        //得到相似度
        for (ImageInfo imageInfo : infoList) {
            if (imageInfo != null);
//            imageInfo.setScore(ImageSimilarity.calSimilarity(rootimage.getPath(), imageInfo.getPath()));
        }

        //排序
        Collections.sort(infoList, new Comparator<ImageInfo>() {
            @Override
            public int compare(ImageInfo o1, ImageInfo o2) {
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

        for (ImageInfo imageInfo : infoList) {
            System.out.println();

            System.out.println(imageInfo);
            System.out.println();
        }

        DecimalFormat format = new DecimalFormat("0.00");
        //取出匹配度前五图片
        for (int i = 1;i < 6;i++){
            ImageInfo imageInfo = infoList.get(i);
            //设置图片路径
            mv.addObject("searchPath_" + i,imageInfo.getPath().split("KDR")[1]);
            //写入相似度
            mv.addObject("semblance_"+ i,format.format(imageInfo.getScore()*100) + "%");
        }

    }


}
