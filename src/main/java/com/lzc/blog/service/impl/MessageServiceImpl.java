package com.lzc.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.blog.mapper.MessageMapper;
import com.lzc.blog.mapper.TypeMapper;
import com.lzc.blog.pojo.Message;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.service.MessageService;
import com.lzc.blog.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@Slf4j
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {


}


