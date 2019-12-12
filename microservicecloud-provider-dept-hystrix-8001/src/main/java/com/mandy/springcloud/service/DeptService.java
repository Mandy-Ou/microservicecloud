package com.mandy.springcloud.service;

import com.mandy.springcloud.dao.DeptDao;
import com.mandy.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MandyOu on 2019/11/26
 */
@Service
public class DeptService {

    @Autowired
    DeptDao deptDao;


    public boolean add(Dept dept){
        return deptDao.addDept(dept);
    }

    public Dept get(Long id){
        return deptDao.findById(id);
    }

    public List<Dept> list(){
        return deptDao.findAll();
    }
}
