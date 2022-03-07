package com.lzc.blog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.annotation.LogAnnotation;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Info;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.*;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Api(value = "首页操作接口")
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private InfoService infoService;


    @GetMapping
    public String toIndex() {
        return "redirect:blogs";
    }

    @GetMapping("/about")
    public String toAbout() {
        return "about";
    }

    @LogAnnotation("进入首页")
    @GetMapping("/blogs")
    public String toBlog(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model, HttpSession session) {
        if (session.getAttribute("info") == null) {
            Long blogNumber = blogService.BlogNumber();
//        获取游客和友链数并+1
            Info info = infoService.getInfo();
            Long customer = info.getCustomer();
            customer = customer + 1;
            infoService.updataCustomer(customer);
            info.setCustomer(customer);
//        存入session
            session.setAttribute("info", info);
            session.setAttribute("blogNumber", blogNumber);
//       分页获取博客
        }
        Page<Blog> pages = new Page<>(page, 5);
        IPage<Blog> blogIPage = blogService.selectBlogs(pages);
//        存入session
        model.addAttribute("pages", blogIPage);
        return "index";
    }

    @GetMapping("/read/{id}")
    public String toRead(Model model, @PathVariable("id") Long id) {
        Blog blog = blogService.getBlogConvert(id);
        List<Tag> tags = tagService.getTagsByTagIds(blog.getTagIds());
        model.addAttribute("blog", blog);
        model.addAttribute("tags", tags);
        return "blog";
    }


    @PostMapping("/search")
    public String search(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         Model model, String query) {
        Page<Blog> pages = new Page<>(page, 5);
        IPage<Blog> blogIPage = blogService.searchBlogs(pages, query);
        model.addAttribute("pages", blogIPage);
        model.addAttribute("query", query);
        return "search";
    }
}
