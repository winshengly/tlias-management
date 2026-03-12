package com.hr.service.impl;

import com.hr.exception.BusinessException;
import com.hr.mapper.DeptMapper;
import com.hr.mapper.EmpMapper;
import com.hr.pojo.Dept;
import com.hr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        //1. 判断部门下是否有员工， 如果有， 需要提示错误信息
        Integer count = empMapper.countByDeptId(id);
        if(count > 0){
            throw new BusinessException("部门下有员工， 不能删除");
        }

        //2. 删除部门
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //1. 补全基础属性 - createTime, updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        //2. 调用Mapper接口方法插入数据
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //1. 补全基础属性-updateTime
        dept.setUpdateTime(LocalDateTime.now());

        //2. 调用Mapper接口方法更新部门
        deptMapper.update(dept);
    }
}
