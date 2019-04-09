package com.zz.service;


import com.zz.pojo.ImageInfo;
import com.zz.pojo.User;

public interface IimageService {


    void addImage(ImageInfo imageInfos, User user);

    ImageInfo getImage(long imageid);
}
