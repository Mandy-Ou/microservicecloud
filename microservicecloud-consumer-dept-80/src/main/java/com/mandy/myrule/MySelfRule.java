package com.mandy.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MandyOu on 2019/12/7
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
//        return new RandomRule();//Ribbon默认是轮询，我自定义为随机
        return new RandomRule_ZY();
    }
}
