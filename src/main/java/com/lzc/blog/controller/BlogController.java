package com.lzc.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogServiceImpl;

    @GetMapping("/toBlogInput")
    public String toBlogInput(){
        return "admin/blog";
    }

    @GetMapping("toBlogs")
    public String toBlogs(){
        return "redirect:admin/blogs";
    }

    @RequestMapping("/blogs")
    public String toBlog(@RequestParam(value = "page",defaultValue = "1")Integer page, Model model){
        Page<Blog> pages = new Page<>(1,5);
        IPage<Blog> blogIPage = blogServiceImpl.selectBlogs(pages);
        model.addAttribute("pages",blogIPage);
        return "admin/blog";
    }
}
