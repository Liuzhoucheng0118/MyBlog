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

    public IPage<Blog> selectBlogs(Page<?> page, @Param("uid")Long uid);

    public IPage<Blog> selectByCondition(Page<?> page, @Param("blogQuery") BlogQuery blogQuery,@Param("uid") Long uid);

    public Integer saveBlog(Blog blog);

    public Blog getBlogById(@Param("id") Long id,@Param("uid")Long uid);

    public Integer updataBlog(Blog blog);

    public Integer deleteBlog(Long id);

    public IPage<Blog> searchBlogs(Page<?> page, @Param("query") String query,@Param("uid")Long uid);

    public Blog getBlogConvert(Long id,@Param("uid")Long uid);

    public Integer updateViews(Long blogId, Integer views);

    public IPage<Blog> selectTagBlogs(Page<?> page, Long tagId);

    public List<String> getAllYear();

    public HashMap<String, List<Blog>> getBlogOfYear(@Param("uid")Long uid);

    public Long BlogNumber(@Param("uid")Long uid);

    public List<Blog> getBlogByIds(List<Long> ids,@Param("uid")Long uid);

}
