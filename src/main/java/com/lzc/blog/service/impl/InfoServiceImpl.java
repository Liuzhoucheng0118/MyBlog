package com.lzc.blog.service.impl;

import com.lzc.blog.mapper.InfoMapper;
import com.lzc.blog.pojo.Info;
import com.lzc.blog.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoMapper infoMapper;

    @Override
    public Info getInfo() {
        return infoMapper.getInfo();
    }

    @Override
    public void updataCustomer(Long number) {
        infoMapper.updataCustomer(number);
    }

    @Override
    public void updataFriends(Long number) {
        infoMapper.updataFriends(number);
    }
}
