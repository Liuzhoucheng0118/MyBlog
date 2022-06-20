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

    @Autowired
    private  UserService userService;


    @GetMapping
    public String toIndex() {
        return "redirect:/user/toIndex";
    }

    @GetMapping("/about")
    public String toAbout() {
        return "about";
    }

    @LogAnnotation("进入首页")
    @GetMapping("/blogs/{uid}")
    public String toBlog(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model,
                         HttpSession session,@PathVariable(value = "uid") String uid) {
        String nowid = (String)session.getAttribute("nowid");
        if (nowid == null ){
            session.setAttribute("nowid",uid);

        }else if (uid !=nowid){
            session.setAttribute("nowid",uid);
        }else{
            uid =(String) session.getAttribute("nowid");
        }
        System.out.println(uid);
        User userById = userService.getUserById(Long.parseLong(uid));
        if(userById != null){
            session.setAttribute("user",userById);
        }
        session.setAttribute("blogNumber","1");
        Page<Blog> pages = new Page<>(page, 5);
        IPage<Blog> blogIPage = blogService.selectBlogs(pages,uid);
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
                         Model model, String query
                         ) {
        Page<Blog> pages = new Page<>(page, 5);
        IPage<Blog> blogIPage = blogService.searchBlogs(pages, query);
        model.addAttribute("pages", blogIPage);
        model.addAttribute("query", query);
        return "search";
    }
}
