package com.lzc.blog.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.lzc.blog.annotation.LogAnnotation;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Api(value = "登录操作接口")
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;


    @GetMapping
    public String toLogin() {
        return "admin/login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repassword,
                           RedirectAttributes attributes){
        User user = userService.cheackUser(username);
        if(user!=null){
            attributes.addFlashAttribute("message", "该用户名已存在");
            return "redirect:/admin";
        }else{
            if(password.equals(repassword)){
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                password = bCryptPasswordEncoder.encode(password);
                user.setNickname(username);
                user.setPassword(password);
                user.setUsername(username);
                user.setCreateTime(new Date());
                user.setAvatar("/images/avater.png");
                userService.add(user);
            }else{
                attributes.addFlashAttribute("message", "密码不一致，请重新输入");
                return "redirect:/admin";
            }
        }

        return "admin/login";
    }

    @PostMapping("/login")
    @LogAnnotation("访问后台")
    public String loginCheack(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session,
                              RedirectAttributes attributes) {

        User user = userService.cheackUser(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (user == null) {
            attributes.addFlashAttribute("message", "用户名错误或不存在");
            return "redirect:/admin";
        } else {
            boolean flag = bCryptPasswordEncoder.matches(password, user.getPassword());
            if (flag) {
                user.setPassword(null);
                session.setAttribute("user", user);
                return "admin/index";
            }
            attributes.addFlashAttribute("message", "密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
