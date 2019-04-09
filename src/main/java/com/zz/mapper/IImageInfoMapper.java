package com.zz.mapper;

import com.zz.pojo.ImageInfo;

public interface IImageInfoMapper {

    void insertImageInfo(ImageInfo imageInfo);

    ImageInfo getImageInfo(long imageid);
}
