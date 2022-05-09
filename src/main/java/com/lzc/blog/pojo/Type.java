package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_type")
public class Type {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Integer uid;
    private String name;
    @TableField(exist = false)
    private List<Blog> blogs;
    @TableField(exist = false)
    private String blogNumber;
}
