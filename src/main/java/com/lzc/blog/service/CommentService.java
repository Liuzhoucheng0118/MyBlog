package com.lzc.blog.service;

import com.lzc.blog.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    public List<Comment> commentChildList(Long blogId);

    public List<Comment> commentParentList(Long blogId);

    public Integer saveComment(Comment comment);

    public List<Comment> commentList(Long blogId);

    public Integer saveUserComment(Comment comment);
}
