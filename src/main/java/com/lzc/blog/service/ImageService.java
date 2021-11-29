package com.lzc.blog.service;

import com.lzc.blog.pojo.Image;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 19:46
 * @Version 1.0
 */
public interface ImageService {
    public List<Image> getAllImage();

    public void addImage(Image image);

    public void deleteImage(Integer id);
}
