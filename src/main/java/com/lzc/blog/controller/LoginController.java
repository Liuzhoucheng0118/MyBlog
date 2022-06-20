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
    @RequestMapping("/toRegister")
    public String toRgister(RedirectAttributes attributes) {
        attributes.addAttribute("message", "该用户名已存在");
        return "admin/register";
    }

    @RequestMapping("/register")
    public String register(@RequestParam(value = "username",defaultValue = "user1") String username,
                           @RequestParam(value = "password",defaultValue = "123") String password,
                           @RequestParam(value = "repassword",defaultValue = "123") String repassword,
                           @RequestParam(value = "nickname",defaultValue = "123") String nickname,
                           RedirectAttributes attributes){
        System.out.println(nickname);
        if(password.equals(repassword)) {
            User user = new User();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            password = bCryptPasswordEncoder.encode(password);
            user.setNickname(username);
            user.setNickname(nickname);
            user.setPassword(password);
            user.setUsername(username);
            user.setAvatar("/images/12.png");
            user.setCreateTime(new Date());
            userService.add(user);
            attributes.addAttribute("message", "注册成功");
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
                session.setAttribute("uid",user.getId().toString());
                session.setAttribute("user",user);
                User update = new User();
                update.setUpdateTime(new Date());
                userService.updata(update);
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
