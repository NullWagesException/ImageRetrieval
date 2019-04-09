package com.zz.service.impl;

import com.zz.mapper.IImageInfoMapper;
import com.zz.mapper.IUserMapper;
import com.zz.pojo.ImageInfo;
import com.zz.pojo.User;
import com.zz.service.IimageService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class imageService implements IimageService {

    @Setter
    @Getter
    private IImageInfoMapper iImageInfoMapper;

    @Setter
    @Getter
    private IUserMapper iUserMapper;

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
