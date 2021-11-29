package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 14:24
 * @Version 1.0
 */
@Mapper
public interface LogMapper {
    public void saveLog(Log log);

    public IPage<Log> getLogs(Page<?> page);

    public void deleteLog(Integer id);

}
