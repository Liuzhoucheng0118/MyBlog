package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 19:36
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_image")
public class Image {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private Integer uid;
    private String image;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String url;

}
