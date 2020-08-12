package com.future.servicefeign.service.impl;

import com.future.servicefeign.service.HelloService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public String hiService(String name) {
		return "sorry " + name;
	}

	@Override
	public String pay(HttpServletRequest request) {
		return "{pay}";
	}

	@Override
	public String payQuery(HttpServletRequest request) {
		return "{payQuery}";
	}

}
