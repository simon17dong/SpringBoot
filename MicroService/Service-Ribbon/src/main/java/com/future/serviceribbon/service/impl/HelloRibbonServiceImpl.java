package com.future.serviceribbon.service.impl;

import com.future.serviceribbon.service.HelloRibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Simon
 */
@Service
public class HelloRibbonServiceImpl implements HelloRibbonService {
	@Autowired
	RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "hiError") // 创建了熔断器的功能，并指定了fallbackMethod熔断方法
	public String hiService(String name) {
		//使用注册到Eureka服务中心的客户端，由客户端分配具体调用哪个服务
		return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
	}

	@Override
	@HystrixCommand(fallbackMethod = "hiError")
	public String hiService(String client, String name) {
		return restTemplate.getForObject("http://" + client + "/hi?name=" + name, String.class);
	}

	private String hiError(String name){
		return "[ribbon] hi " + name + ", sorry error!";
	}

}
