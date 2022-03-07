package com.lzc.blog.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.mapper.ImageMapper;
import com.lzc.blog.pojo.Image;
import com.lzc.blog.service.ImageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 19:46
 * @Version 1.0
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public List<Image> getAllImage() {
        return imageMapper.getAllImage();
    }

    @Override
    public void addImage(Image image) {
        image.setCreateTime(new Date());
        imageMapper.addImage(image);
    }

    @Override
    public void deleteImage(Integer id) {
        imageMapper.deleteImage(id);
    }

    @Override
    public Page<Image> getImages(Page<?> page) {
        return imageMapper.getImages(page);
    }
}
