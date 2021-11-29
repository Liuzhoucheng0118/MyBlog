package com.lzc.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.blog.pojo.Friend;
import com.lzc.blog.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FriendMapper extends BaseMapper<Friend> {
    public void updateShow(Integer id);

    public List<Friend> getShowFriend();
}
