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
@ToString
@NoArgsConstructor
@TableName("t_user")
public class User {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private List<Blog> blogs;
}
