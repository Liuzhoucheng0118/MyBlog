package com.lzc.blog.controller;

import com.lzc.blog.pojo.Comment;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "留言操作接口")
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String commentList(Model model, @PathVariable("blogId") Long blogId) {
        List<Comment> cl = commentService.commentParentList(blogId);
        System.out.println(cl.size());
        model.addAttribute("comments", cl);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String saveComment(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar("/images/avater.png");
            comment.setAdminComment("1");
            commentService.saveUserComment(comment);
        } else {
            comment.setAvatar(avatar);
            commentService.saveComment(comment);
        }
        return "redirect:/comments/" + blogId;
    }

}
