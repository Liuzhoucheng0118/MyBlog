package com.lzc.blog.controller;

import com.lzc.blog.pojo.Friend;
import com.lzc.blog.service.FriendService;
import com.lzc.blog.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.dc.pr.PRError;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private InfoService infoService;

    @RequestMapping("/friends")
    public String toFriends(Model model){

        List<Friend> showFriend = friendService.getShowFriend();
        model.addAttribute("friends",showFriend);
        return "friends";
    }


    @PostMapping("/apply")
    public String apply(Friend friend, Model model){
        friendService.save(friend);
        model.addAttribute("message","申请成功");
        return "friends";
    }
}
