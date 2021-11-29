package com.lzc.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.mapper.LogMapper;
import com.lzc.blog.pojo.Log;
import com.lzc.blog.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 15:27
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public void saveLog(Log log) {
        logMapper.saveLog(log);
    }

    @Override
    public IPage<Log> getLogs(Page<?> page) {
        return logMapper.getLogs(page);
    }

    @Override
    public void deleteLog(Integer id) {
        logMapper.deleteLog(id);
    }
}
