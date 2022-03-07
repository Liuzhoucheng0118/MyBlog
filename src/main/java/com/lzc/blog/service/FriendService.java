package com.lzc.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.blog.pojo.Friend;
import com.lzc.blog.pojo.Message;

import java.util.List;

public interface FriendService extends IService<Friend> {
    void updateShow(Integer id);

    List<Friend> getShowFriend();

    IPage<Friend> getAllFriend(Page<Friend> pages);

    void toCloaseFriend(Integer id);

    void deleteFriendById(Integer id);
}
