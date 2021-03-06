package com.lzc.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.utils.MarkdownUtils;
import com.lzc.blog.vo.BlogQuery;
import com.lzc.blog.mapper.BlogMapper;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.service.BlogService;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;


    @Override
    public IPage<Blog> selectBlogs(Page<?> page, Long uid) {
        return null;
    }

    @Override
    public IPage<Blog> selectByCondition(Page<?> page, BlogQuery blogQuery, Long uid) {
        return null;
    }

    @Override
    public Integer saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        String tagIds = blog.getTagIds();
        char[] chars = tagIds.toCharArray();
        for (char c : chars) {

        }
        blog.setViews(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public Blog getBlogById(Long id, Long uid) {
        return null;
    }


    @Override
    public Integer updataBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        return blogMapper.updataBlog(blog);
    }

    @Override
    public Integer deleteBlog(Long id) {
        return blogMapper.deleteBlog(id);
    }

    @Override
    public IPage<Blog> searchBlogs(Page<?> page, String query, Long uid) {
        return null;
    }

    @Override
    public Blog getBlogConvert(Long id, Long uid) {
        Blog blog = blogMapper.getBlogConvert(id);
        String blogcontent = blog.getContent();
        String content = MarkdownUtils.markdownToHtmlExtensions(blogcontent);
        blog.setContent(content);
//      阅读+1
        Integer views = blog.getViews() + 1;
        updateViews(blog.getId(), views);

        blog.setViews(views);

        return blog;
    }


    @Override
    public Integer updateViews(Long blogId, Integer views) {
        return blogMapper.updateViews(blogId, views);
    }

    @Override
    public IPage<Blog> selectTagBlogs(Page<?> page, Long tagId) {
        return blogMapper.selectTagBlogs(page, tagId);
    }

    @Override
    public List<String> getAllYear() {
        return blogMapper.getAllYear();
    }

    @Override
    public HashMap<String, List<Blog>> getBlogOfYear(Long uid) {
        List<String> allYear = blogMapper.getAllYear();
        HashMap<String, List<Blog>> blogMap = new HashMap<>();
        for (String year : allYear) {
            List<Blog> blogOfYear = blogMapper.getBlogOfYear(year);
            blogMap.put(year, blogOfYear);
        }
        return blogMap;
    }

    @Override
    public Long BlogNumber(Long uid) {
        return blogMapper.BlogNumber(uid);
    }

    @Override
    public List<Blog> getBlogByIds(@Param("ids") List<Long> ids,@Param("uid") Long uid){
        return blogMapper.getBlogByIds(ids);
    }

}
