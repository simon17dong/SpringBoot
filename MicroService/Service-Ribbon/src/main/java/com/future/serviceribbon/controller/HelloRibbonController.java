package com.future.serviceribbon.controller;

import com.future.serviceribbon.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloRibbonController {
	/**
	 *
	 */
	@Autowired
	HelloRibbonService service;
	@Autowired
	DiscoveryClient clients;

	@RequestMapping("**/hi")
	public String hi(@RequestParam String name) {
		return service.hiService(name);
	}

	@RequestMapping("/his")
	public String hi(@RequestParam String client, @RequestParam String name) {
		return service.hiService(client, name);
	}

	@RequestMapping("/list")
	public void list() {
		List<String> services = clients.getServices();
		for (String serviceId : services) {
			List<ServiceInstance> instanceList = clients.getInstances(serviceId);
			for (ServiceInstance instance : instanceList) {
				System.out.println("/hello服务的serviceId:" + serviceId + ",host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
			}
		}
	}
}
