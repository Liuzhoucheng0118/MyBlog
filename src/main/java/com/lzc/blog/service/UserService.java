package com.lzc.blog.service;

import com.lzc.blog.pojo.User;

public interface UserService {

    public User cheackUser(String username);

    public User getUserById(Long id);

    int add(User user);
}
