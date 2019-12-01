package com.mandy.springcloud.controller;

import com.mandy.springcloud.entity.Dept;
import com.mandy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MandyOu on 2019/11/26
 */

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }
}
