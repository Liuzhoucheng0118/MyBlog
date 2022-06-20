package com.lzc.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.vo.BlogQuery;
import com.lzc.blog.pojo.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

public interface BlogService {

    public IPage<Blog> selectBlogs(Page<?> page,String uid);

    public IPage<Blog> selectByCondition(Page<?> page, @Param("blogQuery") BlogQuery blogQuery,@Param("uid") String uid);

    public Integer saveBlog(Blog blog);

    public Blog getBlogById(@Param("id") Long id);

    public Integer updataBlog(Blog blog);

    public Integer deleteBlog(Long id);

    public IPage<Blog> searchBlogs(Page<?> page, @Param("query") String query);

    public Blog getBlogConvert(Long id);

    public Integer updateViews(Long blogId, Integer views);

    public IPage<Blog> selectTagBlogs(Page<?> page, Long tagId);

    public List<String> getAllYear();

    public HashMap<String, List<Blog>> getBlogOfYear(@Param("uid")String uid);

    public Long BlogNumber(@Param("uid")String uid);

    public List<Blog> getBlogByIds(List<Long> ids);

}
