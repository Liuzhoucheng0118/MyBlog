package com.lzc.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Info;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.BlogService;
import com.lzc.blog.service.InfoService;
import com.lzc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 刘周城
 * @Date 2022/5/23 22:45
 * @Email 369039150@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private InfoService infoService;
    @RequestMapping("/toIndex")
    public String  getUserList(@RequestParam(value = "page",defaultValue = "1")Integer pageIndex
                                    , Model model, HttpSession session){
        if (session.getAttribute("info") == null) {
            Long blogNumber = blogService.BlogNumber("1");
//        获取游客和友链数并+1
            Info info = infoService.getInfo();
            Long customer = info.getCustomer();
            customer = customer + 1;
            infoService.updataCustomer(customer);
            info.setCustomer(customer);
//        存入session
            session.setAttribute("info", info);
//            session.setAttribute("blogNumber", blogNumber);
//       分页获取博客
        }
        Page page = new Page(pageIndex,5);
        IPage<User> userList = userService.getUserList(page);
        model.addAttribute("pages",userList);
        return "user";
    }
    @RequestMapping("/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes) {
        User user = new User();
        user.setId(id);
        Integer lines = userService.delete(user);
        if (lines == 1) {
            attributes.addFlashAttribute("message", "成功删除了");
        } else {
            attributes.addFlashAttribute("message", "分类删除失败");
        }
        return "redirect:/user/admin/toIndex";
    }

    @RequestMapping("/admin/toIndex")
    public String  getUseradminList(@RequestParam(value = "page",defaultValue = "1")Integer pageIndex
            , Model model, HttpSession session){
        if (session.getAttribute("info") == null) {
            Long blogNumber = blogService.BlogNumber("1");
//        获取游客和友链数并+1
            Info info = infoService.getInfo();
            Long customer = info.getCustomer();
            customer = customer + 1;
            infoService.updataCustomer(customer);
            info.setCustomer(customer);
//        存入session
            session.setAttribute("info", info);
//            session.setAttribute("blogNumber", blogNumber);
//       分页获取博客
        }
        Page page = new Page(pageIndex,5);
        IPage<User> userList = userService.getUserList(page);
        model.addAttribute("pages",userList);
        return "/admin/user";
    }
}
