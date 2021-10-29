package com.lzc.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    //    跳转到新增分类页
    @RequestMapping("/tagInput")
    public String totagInput() {
        return "admin/tags-input";
    }


    //    分类查询分页
    @RequestMapping("/tags")
    public String toTagPage(@RequestParam(value = "page", defaultValue = "1") Integer pages
            , Model model) {
        Page<Tag> page = new Page<>(pages, 5);
        Page<Tag> tagList = tagService.page(page, null);
        model.addAttribute("pages", tagList);
        return "admin/tags";
    }

    //    根据id删除分类
    @RequestMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes) {
        Integer lines = tagService.deleteTag(id);
        if (lines == 1) {
            attributes.addFlashAttribute("message", "成功删除了一条分类");
        } else {
            attributes.addFlashAttribute("message", "分类删除失败");
        }
        return "redirect:/admin/tags";
    }

    //    保存新的分类
    @PostMapping("/tags")
    public String saveTag(Tag tag, RedirectAttributes attributes) {

        Tag tagFlag = tagService.getByTagname(tag.getName());

        if (tagFlag != null) {
            attributes.addFlashAttribute("message", "分类已经存在");
            return "redirect:/admin/tagInput";
        }

        Integer lines = tagService.saveTag(tag);
        if (lines == 1) {
            attributes.addFlashAttribute("message", "成功添加了一条分类");
        } else {
            attributes.addFlashAttribute("message", "分类添加失败");
        }
        return "redirect:/admin/tags";
    }

//    跳转到编辑页面
    @RequestMapping("/tags/{id}/input")
    public String edittag(@PathVariable Long id, Model model){
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return "admin/tags-edit";
    }

//    更新标签
    @PostMapping("/tags/{id}")
    public String updatetag(Tag tag ,@PathVariable Long id,Model model) {

        Tag tagInfo = tagService.getTag(id);
        if (tagInfo.getName().equals(tag.getName())) {
            model.addAttribute("message", "分类未修改，无需操作");
            model.addAttribute("tag",tag);
            return "admin/tags-edit";
        }

        Integer lines = tagService.updateTag(tag);
        if (lines == 1) {
            model.addAttribute("message", "修改了一条分类");
        } else {
            model.addAttribute("message", "分类修改失败");
        }
        return "redirect:/admin/tags";
    }

}
