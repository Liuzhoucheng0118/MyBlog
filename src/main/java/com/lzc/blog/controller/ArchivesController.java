package com.lzc.blog.controller;

import com.lzc.blog.pojo.Blog;
import com.lzc.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class ArchivesController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        HashMap<String, List<Blog>> map = blogService.getBlogOfYear();
        model.addAttribute("yearMap",map);
        return "archives";
    }
}
