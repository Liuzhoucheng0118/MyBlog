package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 19:41
 * @Version 1.0
 */
@Mapper
public interface ImageMapper {

    public List<Image> getAllImage();

    public void addImage(Image image);

    public void deleteImage(Integer id);

    public Page<Image> getImages(Page<?> page);
}
