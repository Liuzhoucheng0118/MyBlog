package com.lzc.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Image;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 19:46
 * @Version 1.0
 */

public interface ImageService {
    List<Image> getAllImage();

    void addImage(Image image);

    void deleteImage(Integer id);

    Page<Image> getImages(Page<?> page);

}
