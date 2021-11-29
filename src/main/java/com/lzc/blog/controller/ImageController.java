package com.lzc.blog.controller;

import com.lzc.blog.pojo.Image;
import com.lzc.blog.service.ImageService;
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
@Controller
@RequestMapping("/admin")
@Api(value = "图片相关操作")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ApiOperation(value = "查询所有的图片")
    @GetMapping("/images")
    public String getAllImage(Model model){
        List<Image> images = imageService.getAllImage();
        model.addAttribute("images",images);
        return "/admin/images";
    }

    @ApiOperation(value = "添加图片")
    @ApiImplicitParam(name = "image",value = "图片实体")
    @PostMapping("/addimage")
    public String addImage(@RequestParam Image image){
        imageService.addImage(image);
        return "redirect:/admin/images";
    }

    @ApiOperation(value = "删除图片通过id")
    @ApiImplicitParam(name = "id",value = "图片的id")
    @GetMapping("/addimage/{id}/delete")
    public String deleteImage(@PathVariable(name = "id") Integer id){
        imageService.deleteImage(id);
        return "redirect:/admin/images";
    }
}
