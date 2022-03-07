package com.lzc.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Image;
import com.lzc.blog.service.ImageService;
import com.lzc.blog.service.TagService;
import com.lzc.blog.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 18:10
 * @Version 1.0
 */
@Api(value = "图片相关操作")
@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "查询所有的图片")
    @GetMapping("/admin/images")
    public String getAllImage(Model model) {
        List<Image> images = imageService.getAllImage();
        model.addAttribute("images", images);
        return "admin/images";
    }

    @ApiOperation(value = "添加图片")
    @ApiImplicitParam(name = "image", value = "图片实体")
    @PostMapping("/admin/addimage")
    public String addImage(Image image) {
        imageService.addImage(image);
        return "redirect:/admin/images";
    }

    @ApiOperation(value = "删除图片通过id")
    @ApiImplicitParam(name = "id", value = "图片的id")
    @GetMapping("/admin/addimage/{id}/delete")
    public String deleteImage(@PathVariable(name = "id") Integer id) {
        imageService.deleteImage(id);
        return "redirect:/admin/images";
    }

    @ApiOperation(value = "前台的图片跳转")
    @ApiImplicitParam(name = "page", value = "第几页图片")
    @GetMapping("/image")
    public String getImages(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        Page<Image> pages = new Page(page, 7);
        Page<Image> images = imageService.getImages(pages);
        model.addAttribute("pages", images);
        return "images";
    }

    @ApiOperation(value = "图片使用")
    @RequestMapping("/admin/userImage")
    public String toUserImage(String url, Model model) {
        Blog blog = new Blog();
        model.addAttribute("url", url);
        model.addAttribute("types", typeService.list());
        model.addAttribute("tags", tagService.list());
        model.addAttribute("blog", blog);
        return "admin/blog-input";
    }

    @ApiOperation(value = "跳转到图片添加页面")
    @RequestMapping("/admin/toInput")
    public String imageInput() {
        return "admin/image-input";
    }

}
