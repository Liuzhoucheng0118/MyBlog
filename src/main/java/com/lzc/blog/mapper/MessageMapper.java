package com.lzc.blog.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.blog.pojo.Message;
import com.lzc.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
