package com.lzc.blog.controller;

import com.lzc.blog.pojo.Blog;
import com.lzc.blog.service.BlogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Api(value = "归档操作接口")
@Controller
public class ArchivesController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model, @RequestParam(value = "uid",defaultValue = "1")String uid) {
        HashMap<String, List<Blog>> map = blogService.getBlogOfYear(uid);
        model.addAttribute("yearMap", map);
        return "archives";
    }
}
