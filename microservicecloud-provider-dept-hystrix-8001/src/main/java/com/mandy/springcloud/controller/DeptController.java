package com.mandy.springcloud.controller;

import com.mandy.springcloud.entity.Dept;
import com.mandy.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MandyOu on 2019/11/26
 */

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService service = null;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = service.get(id);
        if(dept == null){
            throw new RuntimeException("该ID:"+id+"没有对应的信息");
        }
        return dept;
    }

    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }


}
