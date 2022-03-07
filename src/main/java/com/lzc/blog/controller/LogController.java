package com.lzc.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Log;
import com.lzc.blog.service.LogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2021/11/29 15:21
 * @Version 1.0
 */

@Api(value = "日志操作接口")
@Controller
@RequestMapping("/admin")
public class LogController {

    @Autowired
    private LogService logService;


    @ApiOperation("日志分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页")})
    @GetMapping("/logs")
    public String getLogs(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        Page<Log> pages = new Page(page, 5);
        IPage<Log> logs = logService.getLogs(pages);
        model.addAttribute("pages", logs);
        model.addAttribute("message", "删除成功");
        return "admin/logs";
    }

    @ApiOperation(value = "删除日志", notes = "根据id删除")
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "日志id"))
    @GetMapping("logs/{id}/delete")
    public String deleteLog(@PathVariable(name = "id") Integer id) {
        logService.deleteLog(id);
        return "redirect:/admin/logs";
    }

}
