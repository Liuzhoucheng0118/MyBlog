package com.lzc.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.condition.BlogCondition;
import com.lzc.blog.mapper.BlogMapper;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public IPage<Blog> selectBlogs(Page<?> page) {
        return blogMapper.selectBlogs(page);
    }

    @Override
    public IPage<Blog> selectByCondition(Page<?> page, BlogCondition blogCondition) {
        return blogMapper.selectByCondition(page,blogCondition);
    }


}
