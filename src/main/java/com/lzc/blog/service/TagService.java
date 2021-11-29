package com.lzc.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.blog.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService extends IService<Tag> {
    //    保存分类
    public Integer saveTag(Tag tag);

    //    得到分类
    public Tag getTag(Long id);

    //    更新分类
    public Integer updateTag(Tag tag);

    //    删除分类
    public Integer deleteTag(Long id);

    //   通过名字获取tag
    public Tag getByTagname(String name);

    public List<Tag> getTagsByTagIds(@Param("ids") String id);

    public List<Tag> getAllTags();
}
