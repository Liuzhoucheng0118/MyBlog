package com.lzc.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.blog.pojo.Friend;
import com.lzc.blog.pojo.Message;

import java.util.List;

public interface FriendService extends IService<Friend> {
    public void updateShow(Integer id);

    public List<Friend> getShowFriend();
}
