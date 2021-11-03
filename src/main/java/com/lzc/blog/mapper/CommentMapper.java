package com.lzc.blog.mapper;

import com.lzc.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public Integer saveComment(Comment comment);

    public List<Comment> commentChildList(Long parentId);

    public List<Comment> commentParentList(Long blogId);

    public List<Comment> commentList(Long blogId);

    public Integer saveUserComment(Comment comment);
}
