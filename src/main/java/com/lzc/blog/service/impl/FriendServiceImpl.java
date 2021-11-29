package com.lzc.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.blog.mapper.FriendMapper;
import com.lzc.blog.mapper.MessageMapper;
import com.lzc.blog.pojo.Friend;
import com.lzc.blog.pojo.Message;
import com.lzc.blog.service.FriendService;
import com.lzc.blog.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@Slf4j
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

    @Resource
    private FriendMapper friendMapper;

    @Override
    public void updateShow(Integer id) {
        friendMapper.updateShow(id);
    }

    @Override
    public List<Friend> getShowFriend() {
        return friendMapper.getShowFriend();
    }

}


