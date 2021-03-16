package com.bingo.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * @author:yaobin
 * @date:2021/3/14,15:22
 */

@Configuration
public class MySelfRule {
    public IRule myRule(){
        return new RandomRule(); //定义为随机
    }
}
