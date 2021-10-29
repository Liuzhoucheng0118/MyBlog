package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
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
}
