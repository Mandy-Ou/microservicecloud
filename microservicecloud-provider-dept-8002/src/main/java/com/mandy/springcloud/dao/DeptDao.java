package com.mandy.springcloud.dao;

import com.mandy.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by MandyOu on 2019/11/26
 */
@Mapper
public interface DeptDao {

    @Insert("insert into dept(dname,db_source) values(#{dname},DATABASE())")
    public boolean addDept(Dept dept);

    @Select("select deptno,dname,db_source from dept where deptno=#{deptno}")
    public Dept findById(Long id);

    @Select("select deptno,dname,db_source from dept")
    public List<Dept> findAll();
}
