package com.lzc.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Friend;
import com.lzc.blog.service.FriendService;
import com.lzc.blog.service.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.dc.pr.PRError;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "友链操作接口")
@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private InfoService infoService;

    @GetMapping("/friends")
    public String toFriends(Model model) {

        List<Friend> showFriend = friendService.getShowFriend();
        model.addAttribute("friends", showFriend);
        return "/friends";
    }

    @ApiOperation(value = "申请成为友链")
    @PostMapping("/apply")
    public String apply(Friend friend, Model model) {
        friendService.save(friend);
        model.addAttribute("message", "申请成功");
        return "/friends";
    }

    @ApiOperation(value = "获取全部的友链信息")
    @ApiImplicitParam(name = "page",value = "第几页友链")
    @GetMapping("/admin/friends")
    public String getImages(@RequestParam(value = "page",defaultValue = "1")Integer page, Model model){
        Page<Friend> pages = new Page(page,7);
        IPage<Friend> friends = friendService.getAllFriend(pages);
        model.addAttribute("pages",friends);
        return "/admin/friends";
    }

    @ApiOperation(value = "激活用户")
    @RequestMapping("/admin/friends/{id}/active")
    public String toActiveUser(@PathVariable(value = "id") Integer id){
        friendService.updateShow(id);
        return "redirect:/admin/friends";
    }
    @ApiOperation(value = "关闭用户")
    @RequestMapping("/admin/friends/{id}/close")
    public String toCloseUser(@PathVariable(value = "id") Integer id){
        friendService.toCloaseFriend(id);
        return "redirect:/admin/friends";
    }
    @ApiOperation(value = "删除用户")
    @RequestMapping("/admin/friends/{id}/delete")
    public String toDeleteUser(@PathVariable(value = "id") Integer id){
        friendService.deleteFriendById(id);
        return "redirect:/admin/friends";
    }


}
