package com.mandy.springcloud.controller;

import com.mandy.springcloud.entity.Dept;
import com.mandy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;


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

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("****************" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" +
                    element.getHost() + "\t" +
                    element.getPort() + "\t" +
                    element.getUri());
        }
        return this.discoveryClient;
//        return srvList;
    }
}
