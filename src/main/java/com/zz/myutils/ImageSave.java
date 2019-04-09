package com.zz.myutils;

import com.zz.pojo.ImageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class ImageSave {
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private ImageSave(){}

    /**
     * 将图片保存到文件夹
     * @param file
     * @param imageInfo
     * @return
     */
    public static boolean savedir(MultipartFile file,ImageInfo imageInfo){
        try {
            String dirname = imageInfo.getRoot();
            File fileroot = new File("D://KDR/" + dirname);
            //当且仅当具有该名称的文件夹尚不存在时，原子地创建一个由该抽象路径名命名的新的空文件夹。
            if (!fileroot.exists()){
                //不存在由此抽象路径名表示的文件或目录时
                fileroot.mkdir();
            }

            inputStream = file.getInputStream();
            String filepath = fileroot.getPath() + "\\" + imageInfo.getImageid() + file.getOriginalFilename();
            outputStream = new FileOutputStream(filepath);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buffer))!= -1){
                outputStream.write(buffer);
            }
            imageInfo.setPath(filepath);
            //进行图片压缩
            ImageCompression.Compression(filepath);

            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
