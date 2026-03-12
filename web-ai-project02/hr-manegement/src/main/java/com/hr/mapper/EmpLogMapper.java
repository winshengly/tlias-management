package com.hr.mapper;

import com.hr.pojo.EmpLog;
import com.hr.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface EmpLogMapper {

    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(EmpLog empLog);

    @Select("select id, operate_time, info from emp_log order by operate_time desc")
    List<OperateLog> list();
}
