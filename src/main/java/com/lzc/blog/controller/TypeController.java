package com.lzc.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.service.TypeService;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    //    跳转到新增分类页
    @RequestMapping("/typeInput")
    public String toTypeInput() {
        return "admin/types-input";
    }


    //    分类查询分页
    @RequestMapping("/types")
    public String toTypePage(@RequestParam(value = "page", defaultValue = "1") Integer pages
            , Model model) {
        Page<Type> page = new Page<>(pages, 5);
        Page<Type> typeList = typeService.page(page, null);
        model.addAttribute("pages", typeList);
        return "admin/types";
    }

    //    根据id删除分类
    @RequestMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes) {
        Integer lines = typeService.deleteType(id);
        if (lines == 1) {
            attributes.addFlashAttribute("message", "成功删除了一条分类");
        } else {
            attributes.addFlashAttribute("message", "分类删除失败");
        }
        return "redirect:/admin/types";
    }

    //    保存新的分类
    @PostMapping("/types")
    public String savetag(Type type, RedirectAttributes attributes) {

        Type tagFlag = typeService.getByTypename(type.getName());

        if (tagFlag != null) {
            attributes.addFlashAttribute("message", "分类已经存在");
            return "redirect:/admin/typeInput";
        }

        Integer lines = typeService.saveType(type);
        if (lines == 1) {
            attributes.addFlashAttribute("message", "成功添加了一条分类");
        } else {
            attributes.addFlashAttribute("message", "分类添加失败");
        }
        return "redirect:/admin/types";
    }

//    跳转到编辑页面
    @RequestMapping("/types/{id}/input")
    public String editType(@PathVariable Long id, Model model){
        Type type = typeService.getType(id);
        model.addAttribute("type",type);
        return "admin/types-edit";
    }

//    更新标签
    @PostMapping("/types/{id}")
    public String updateType(Type type,@PathVariable Long id, Model model) {

        Type typeInfo = typeService.getType(id);
        if (typeInfo.getName().equals(type.getName())) {
            model.addAttribute("message", "分类未修改，无需操作");
            model.addAttribute("type",type);
            return "admin/types-edit";
        }

        Integer lines = typeService.updateType(type);
        if (lines == 1) {
            model.addAttribute("message", "修改了一条分类");
        } else {
            model.addAttribute("message", "分类修改失败");
        }
        return "redirect:/admin/types";
    }

}
