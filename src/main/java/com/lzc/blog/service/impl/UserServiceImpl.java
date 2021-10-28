package com.lzc.blog.service.impl;

import com.lzc.blog.mapper.UserMapper;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User cheackUser(String username) {
        return userMapper.cheackUser(username);
    }
}
