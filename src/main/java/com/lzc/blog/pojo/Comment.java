package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_comment")
public class Comment {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Blog blog;
    private String adminComment;
    @TableField(exist = false)
    private String parentCommentName;

    private List<Comment> replayComments;

    private Comment parentComment;

}
