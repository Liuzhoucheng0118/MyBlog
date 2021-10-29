package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.condition.BlogCondition;
import com.lzc.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    IPage<Blog> selectBlogs(Page<?> page);

    IPage<Blog> selectByCondition(Page<?> page,@Param("bc") BlogCondition blogCondition);
}
