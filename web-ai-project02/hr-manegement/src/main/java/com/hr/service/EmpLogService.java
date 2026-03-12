package com.hr.service;

import com.hr.pojo.EmpLog;
import com.hr.pojo.OperateLog;
import com.hr.pojo.PageResult;

public interface EmpLogService {

    public void insertLog(EmpLog empLog);

    PageResult<OperateLog> page(Integer page, Integer pageSize);

}
