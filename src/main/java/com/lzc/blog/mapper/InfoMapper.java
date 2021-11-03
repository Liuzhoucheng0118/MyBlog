package com.lzc.blog.mapper;

import com.lzc.blog.pojo.Info;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InfoMapper {

    public Info getInfo();

    public void updataCustomer(Long number);


    public void updataFriends(Long number);

}
