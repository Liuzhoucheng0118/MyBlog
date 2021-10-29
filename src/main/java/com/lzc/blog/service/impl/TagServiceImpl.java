package com.lzc.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzc.blog.mapper.TagMapper;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    private TagMapper tagMapper;
    @Override
    public Integer saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.getTag(id);
    }

    @Override
    public Integer updateTag(Tag tag) {
        System.out.println(tag.getId());
        Tag selecttag = tagMapper.getTag(tag.getId());
        if(selecttag==null){
            log.error("没有该标签:{}",tag.getName());
            return -1;
        }
        return  tagMapper.updateTag(tag);
    }

    @Override
    public Integer deleteTag(Long id) {
        Tag selecttag = tagMapper.getTag(id);
        if(selecttag==null){
            log.error("该分类已经不存在");
            return -1;
        }
        return tagMapper.deleteTag(id);
    }

    @Override
    public Tag getByTagname(String name) {
        return tagMapper.getByTagname(name);
    }
}


