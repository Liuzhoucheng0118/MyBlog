package com.lzc.blog.pojo;

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
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Blog blog;

    private List<Comment> replayComments;

    private Comment parentComment;

}
