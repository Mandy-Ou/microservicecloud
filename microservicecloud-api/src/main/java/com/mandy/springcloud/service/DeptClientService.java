package com.mandy.springcloud.service;

import com.mandy.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 关于Hystrix:
 * 修改microservicecloud-api工程，根据已经有的DeptClientService接口
 * 新建一个实现了FallBackFactory接口的类DeptClientServiceFallBackFactory
 * Created by MandyOu on 2019/12/8
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

}
