package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_friend")
public class Friend {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String userinfo;
    private String webadress;
    private Integer showStatement;
}
