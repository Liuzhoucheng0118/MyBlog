package com.lzc.blog.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.UserService;
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

@Controller
@RequestMapping("/admin")
public class LoginController {
   @Autowired
    private UserService userService;


   @GetMapping
   public String toLogin(){
       return "admin/login";
   }


    @PostMapping("/login")
    public String loginCheack(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session,
                              RedirectAttributes attributes){

        User user = userService.cheackUser(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(user==null) {
            attributes.addFlashAttribute("message","用户名错误或不存在");
            return "redirect:/admin";
        }
        else {
            boolean flag = bCryptPasswordEncoder.matches(password, user.getPassword());
            if(flag){
                user.setPassword(null);
                session.setAttribute("user",user);
                return "admin/index";
            }
            attributes.addFlashAttribute("message","密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String loginOut(HttpSession session){
       session.removeAttribute("user");
       return "redirect:/admin";
    }
}
