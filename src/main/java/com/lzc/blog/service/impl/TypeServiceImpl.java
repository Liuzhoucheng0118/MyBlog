package com.lzc.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.blog.mapper.TypeMapper;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@Slf4j
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Resource
    private  TypeMapper typeMapper;
    @Override
    public Integer saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }

    @Override
    public Integer updateType(Type tag) {
        System.out.println(tag.getId());
        Type selecttag = typeMapper.getType(tag.getId());
        if(selecttag==null){
            log.error("没有该分类:{}",tag.getName());
            return -1;
        }
        return  typeMapper.updateType(tag);
    }

    @Override
    public Integer deleteType(Long id) {
        Type selectType = typeMapper.getType(id);
        if(selectType==null){
            log.error("该分类已经不存在");
            return -1;
        }
        return typeMapper.deleteType(id);
    }

    @Override
    public Type getByTypename(String name) {
        return typeMapper.getByTypename(name);
    }

    @Override
    public List<Type> getTypeBlogs() {
        return typeMapper.getTypeBlogs();
    }
}


