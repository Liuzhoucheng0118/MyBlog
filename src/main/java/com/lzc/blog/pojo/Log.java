package com.lzc.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 12:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_log")
public class Log {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String username;
    private String ip;
    private Date createTime;
    private String operation;
    private String flag;
    private String browser;
}
