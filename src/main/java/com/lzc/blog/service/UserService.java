package com.lzc.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.User;

public interface UserService {

    public User cheackUser(String username);

    public User getUserById(Long id);

    int add(User user);

    IPage<User> getUserList(Page<?> page);

    int delete(User user);

    int updata(User user);
}
