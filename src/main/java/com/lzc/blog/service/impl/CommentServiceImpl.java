package com.lzc.blog.service.impl;

import com.lzc.blog.mapper.BlogMapper;
import com.lzc.blog.mapper.CommentMapper;
import com.lzc.blog.pojo.Comment;
import com.lzc.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private BlogMapper blogMapper;

    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> commentList(Long blogId) {
        return commentMapper.commentList(blogId);
    }


    @Override
    public Integer saveComment(Comment comment) {
        Long id = comment.getParentComment().getId();
        comment.setCreateTime(new Date());
        comment.setAdminComment(null);
        Integer flag = -1;
        if (id != -1) {
            flag = commentMapper.saveComment(comment);
        } else {
            comment.getParentComment().setId(null);
            flag = commentMapper.saveComment(comment);
        }
        return flag;
    }


    @Override
    public List<Comment> commentParentList(Long blogId) {
        List<Comment> parentList = commentMapper.commentParentList(blogId);
        for (Comment parentComment : parentList) {
            String parentCommentNickname = parentComment.getNickname();
            recursively(parentComment.getId(), parentCommentNickname);
            parentComment.setReplayComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return parentList;
    }

    private void recursively(Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentMapper.commentChildList(childId);

        if (replayComments.size() > 0) {
            for (Comment replayComment : replayComments) {
                String parentNickname = replayComment.getNickname();
                replayComment.setParentCommentName(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                //循环迭代找出子集回复
                recursively(replayId, parentNickname);
            }
        }
    }


    @Override
    public List<Comment> commentChildList(Long blogId) {
        return commentMapper.commentChildList(blogId);
    }

    @Override
    public Integer saveUserComment(Comment comment) {
        Long id = comment.getParentComment().getId();
        comment.setCreateTime(new Date());
        Integer flag = -1;
        if (id != -1) {
            flag = commentMapper.saveUserComment(comment);
        } else {
            comment.getParentComment().setId(null);
            flag = commentMapper.saveUserComment(comment);
        }
        return flag;
    }

}
