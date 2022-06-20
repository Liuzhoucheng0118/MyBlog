package com.lzc.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.BlogService;
import com.lzc.blog.service.TagService;
import com.lzc.blog.service.TypeService;
import com.lzc.blog.vo.BlogQuery;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(value = "文章操作接口")
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogServiceImpl;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/toBlogInput")
    public String toBlogInput(Model model) {
        Blog blog = new Blog();
        model.addAttribute("types", typeService.list());
        model.addAttribute("tags", tagService.list());
        model.addAttribute("blog", blog);
        return "admin/blog-input";
    }

    @GetMapping("toBlogs")
    public String toBlogs() {
        return "redirect:admin/blogs";
    }

    @GetMapping("/blogs")
    public String toBlog(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model, HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("uid");
        Page<Blog> pages = new Page<>(page, 5);
        IPage<Blog> blogIPage = blogServiceImpl.selectBlogs(pages,uid);
        model.addAttribute("pages", blogIPage);
        model.addAttribute("types", typeService.list());
        return "admin/blog";
    }

    @PostMapping("/blogs/search")
    public String searchBlog(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             Model model,
                             BlogQuery blogQuery,
                             HttpServletRequest request) {
        String uid = (String)request.getSession().getAttribute("uid");
        Page<Blog> pages = new Page<>(page, 5);
        IPage<Blog> blogIPage = blogServiceImpl.selectByCondition(pages, blogQuery,uid);
        model.addAttribute("pages", blogIPage);
        return "admin/blog::blogList";
    }


    @PostMapping("/blogs")
    public String addBlog(Blog blog, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        String uid = (String)session.getAttribute("uid");
        blog.setUser(user);
        Integer integer = blogServiceImpl.saveBlog(blog);
        if (integer == 1) {
            model.addAttribute("message", "增加了一条新的文章");
        } else {
            model.addAttribute("message", "文章添加失败");
            return "admin/blog-input";
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/input")
    public String editBlog(@PathVariable("id") Long id, Model model, String uid) {
        Blog blog = blogServiceImpl.getBlogById(id);
        model.addAttribute("types", typeService.list());
        model.addAttribute("tags", tagService.list());
        model.addAttribute("blog", blog);
        return "admin/blog-edit";
    }

    @PostMapping("/editBlog")
    public String updataBlog(Blog blog, HttpSession session, Model model) {
        System.out.println(blog.toString());
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        Integer flag = blogServiceImpl.updataBlog(blog);
        if (flag == 1) {
            model.addAttribute("message", "更新成功");
        } else {
            model.addAttribute("message", "文章更新失败");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("blogs/{id}/delete")
    public String deleteBlog(@PathVariable("id") Long id, Model model) {
        Integer flag = blogServiceImpl.deleteBlog(id);
        if (flag == 1) {
            model.addAttribute("message", "删除成功");
        } else {
            model.addAttribute("message", "删除失败");
        }
        return "redirect:/admin/blogs";
    }
}
