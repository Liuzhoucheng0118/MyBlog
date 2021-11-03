package com.lzc.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.service.BlogService;
import com.lzc.blog.service.TagService;
import com.lzc.blog.service.TypeService;
import com.lzc.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TagIndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @GetMapping("/tags/{id}")
    public String types(@RequestParam(value = "page", defaultValue = "1") Integer pages,
                        Model model, @PathVariable("id") Long tagId, HttpSession session){

        if(session.getAttribute("tags")==null){
            List<Tag> tags = tagService.getAllTags();
            session.setAttribute("tags",tags);
        }
        if(tagId==-1){
            IPage<Blog> blogIPage = blogService.selectBlogs(new Page<>(pages, 5));
            model.addAttribute("pages",blogIPage);
        }else{
            IPage<Blog> blogIPage = blogService.selectTagBlogs(new Page<>(pages, 5),tagId);
            model.addAttribute("pages",blogIPage);
        }
        model.addAttribute("activeTypeId",tagId);
        return "tags";
    }
}
