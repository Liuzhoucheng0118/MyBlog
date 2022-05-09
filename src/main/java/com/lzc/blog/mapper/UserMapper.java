package com.lzc.blog.mapper;

import com.lzc.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int add(User user);

    public User cheackUser(String username);

    public User getUserById(Long id);
}
