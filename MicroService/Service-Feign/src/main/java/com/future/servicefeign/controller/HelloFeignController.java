package com.future.servicefeign.controller;

import com.future.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/feign")
public class HelloFeignController {
    @Autowired
	HelloService service;

    @GetMapping("**/hi")
    public String hi(@RequestParam String name) {
        return service.hiService(name);
    }

	@PostMapping("feign")
	public String pay(@RequestParam HttpServletRequest request){
		return service.pay(request);
	}

	@PostMapping("payQuery")
	public String payQuery(@RequestParam HttpServletRequest request){
		return service.payQuery(request);
	}
}
