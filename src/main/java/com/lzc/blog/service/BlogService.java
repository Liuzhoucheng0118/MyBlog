package com.lzc.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.condition.BlogCondition;
import com.lzc.blog.pojo.Blog;
import org.apache.ibatis.annotations.Param;

public interface BlogService {

    IPage<Blog> selectBlogs(Page<?> page);

    IPage<Blog> selectByCondition(Page<?> page,BlogCondition blogCondition);
}
