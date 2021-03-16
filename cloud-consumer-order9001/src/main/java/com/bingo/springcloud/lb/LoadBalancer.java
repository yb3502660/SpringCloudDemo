package com.bingo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author:yaobin
 * @date:2021/3/14,18:51
 */

public interface LoadBalancer  {
      
    ServiceInstance instances(List<ServiceInstance> serviceInstances);    
    
}
