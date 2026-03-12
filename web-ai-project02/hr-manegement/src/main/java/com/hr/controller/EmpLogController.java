package com.hr.controller;

import com.hr.pojo.*;
import com.hr.service.EmpLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class EmpLogController {
    @Autowired
    private EmpLogService empLogService;
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page ,@RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("访问了 EmpLogService 的 page 方法");
        PageResult<OperateLog> pageResult = empLogService.page(page , pageSize);
        return Result.success();
    }

}
