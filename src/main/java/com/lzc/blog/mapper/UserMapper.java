package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int add(User user);

    public User cheackUser(String username);

    public User getUserById(Long id);

    IPage<User> getUserList(Page<?> page);

    int delete(User user);

    int updata(User user);
}
