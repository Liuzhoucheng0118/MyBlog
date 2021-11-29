package com.lzc.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzc.blog.pojo.Type;

import java.util.List;

public interface TypeService extends IService<Type> {
    //    保存分类
    public Integer saveType(Type type);

    //    得到分类
    public Type getType(Long id);

    //    更新分类
    public Integer updateType(Type type);

    //    删除分类
    public Integer deleteType(Long id);

    public Type getByTypename(String name);

    public List<Type> getTypeBlogs();
}
