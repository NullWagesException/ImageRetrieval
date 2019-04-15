package com.zz.service.impl;

import com.zz.mapper.IImageInfoMapper;
import com.zz.mapper.IUserMapper;
import com.zz.pojo.ImageInfo;
import com.zz.pojo.User;
import com.zz.service.IimageService;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class imageService implements IimageService {
    private IImageInfoMapper iImageInfoMapper;

    public void setiImageInfoMapper(IImageInfoMapper iImageInfoMapper) {
        this.iImageInfoMapper = iImageInfoMapper;
    }

    private IUserMapper iUserMapper;

    public void setiUserMapper(IUserMapper iUserMapper) {
        this.iUserMapper = iUserMapper;
    }

    @Override
    public void addImage(ImageInfo imageInfos, User user) {
        iUserMapper.insertUser(user);
        imageInfos.setUid(user.getPhoneid());
        iImageInfoMapper.insertImageInfo(imageInfos);
    }

    public ImageInfo getImage(long imageid){
        return iImageInfoMapper.getImageInfo(imageid);
    }
}
