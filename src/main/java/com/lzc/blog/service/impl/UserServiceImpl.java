package com.lzc.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public IPage<User> getUserList(Page<?> page) {
        return userMapper.getUserList(page);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

    @Override
    public int updata(User user) {
        return userMapper.updata(user);
    }
}
