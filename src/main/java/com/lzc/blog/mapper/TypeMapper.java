package com.lzc.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzc.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
    //    保存分类
    public Integer saveType(Type type);
    //    得到分类
    public Type getType(Long id);
    //    更新分类
    public Integer updateType(Type type);
    //    删除分类
    public Integer deleteType(Long id);
    //   通过名字获取Type
    public Type getByTypename(String name);
}
