package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Integer uid;
    private String name;
    @TableField(exist = false)
    private List<Blog> blogs;
}
