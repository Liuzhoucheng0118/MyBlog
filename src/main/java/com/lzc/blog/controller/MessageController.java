package com.lzc.blog.controller;


import com.lzc.blog.pojo.Message;
import com.lzc.blog.service.MessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Api(value = "留言操作接口")
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/messages")
    public String commentList(Model model) {
        List<Message> messageList = messageService.list();
        model.addAttribute("messages", messageList);
        return "friends :: messageList";
    }

    @PostMapping("/message")
    public String saveMessage(Message message, HttpSession session) {
        if (session.getAttribute("user") != null) {
            message.setAdmincomment("true");
        }
        if (session.getAttribute("user") != null) {
            message.setAvatar("/images/avater.png");
        } else {
            message.setAvatar(avatar);
        }

        message.setCreateTime(new Date());
        messageService.save(message);
        return "redirect:/messages";
    }
}
