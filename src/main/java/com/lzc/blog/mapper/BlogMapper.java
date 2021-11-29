package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.vo.BlogQuery;
import com.lzc.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    public IPage<Blog> selectBlogs(Page<?> page);

    public IPage<Blog> selectByCondition(Page<?> page, @Param("bq") BlogQuery blogQuery);

    public Integer saveBlog(Blog blog);

    public Blog getBlogById(Long id);

    public Integer updataBlog(Blog blog);

    public Integer deleteBlog(Long id);

    public IPage<Blog> searchBlogs(Page<?> page, String query);

    public Blog getBlogConvert(Long id);

    public Long blogIsEmpty(Long id);

    public Integer updateViews(Long blogId, Integer views);

    public IPage<Blog> selectTagBlogs(Page<?> page, Long tagId);

    public List<String> getAllYear();

    public List<Blog> getBlogOfYear(String year);

    public Long BlogNumber();
}
