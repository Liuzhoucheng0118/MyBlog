package com.lzc.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Log;
import com.lzc.blog.vo.BlogQuery;

import java.util.HashMap;
import java.util.List;

public interface LogService {

    public void saveLog(Log log);

    public IPage<Log> getLogs(Page<?> page);

    public void deleteLog(Integer id);
}
