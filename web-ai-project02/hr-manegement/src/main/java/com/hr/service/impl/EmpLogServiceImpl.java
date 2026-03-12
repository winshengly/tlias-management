package com.hr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hr.mapper.EmpLogMapper;
import com.hr.pojo.EmpLog;
import com.hr.pojo.OperateLog;
import com.hr.pojo.PageResult;
import com.hr.pojo.Student;
import com.hr.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW) //需要在一个新的事务中运行
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
//        System.out.println("page:" + page + " pageSize:" + pageSize);
        PageHelper.startPage(page, pageSize);
        List<OperateLog> operateLogList = empLogMapper.list();
        Page<OperateLog> p = (Page<OperateLog>) operateLogList;
        return new PageResult(p.getTotal(), p.getResult());
    }
}
