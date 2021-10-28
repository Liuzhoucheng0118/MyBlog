package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_tag")
public class Tag {
    private Long id;
    private String name;

    private List<Blog> blogs;
}