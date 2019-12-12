package com.mandy.springcloud.controller;

import com.mandy.springcloud.entity.Dept;
import com.mandy.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MandyOu on 2019/12/1
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.get(id);
    }

    @RequestMapping(value = "/list")
    public List<Dept> list(){
        return this.deptClientService.list();
    }

    @RequestMapping(value = "/add")
    public Boolean add(Dept dept){
        return this.deptClientService.add(dept);
    }
}
