package com.lzc.blog.service;

import com.lzc.blog.pojo.Info;

public interface InfoService {
    public Info getInfo();

    public void updataCustomer(Long number);


    public void updataFriends(Long number);
}
