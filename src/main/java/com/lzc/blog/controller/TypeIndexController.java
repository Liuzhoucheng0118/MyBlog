package com.lzc.blog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.service.BlogService;
import com.lzc.blog.service.TypeService;
import com.lzc.blog.vo.BlogQuery;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "首页分配操作接口")
@Controller
public class TypeIndexController {


    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/types/{id}")
    public String types(@RequestParam(value = "page", defaultValue = "1") Integer pages,
                        Model model, @PathVariable("id") Long typeId, HttpSession session) {
//      session是否已经加入了type列表
        if (session.getAttribute("types") == null) {
            List<Type> typeBlogs = typeService.getTypeBlogs();
            session.setAttribute("types", typeBlogs);
        }
//        如果没有任何标签选中
        if (typeId == -1) {
            IPage<Blog> blogIPage = blogService.selectBlogs(new Page<>(pages, 5));
            model.addAttribute("pages", blogIPage);
        } else {
            IPage<Blog> blogIPage = blogService.selectByCondition(new Page<>(pages, 5), new BlogQuery(null, typeId));
            model.addAttribute("pages", blogIPage);
        }
        model.addAttribute("activeTypeId", typeId);
        return "types";
    }
}
