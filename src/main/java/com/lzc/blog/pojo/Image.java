package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String image;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    private String url;

}
