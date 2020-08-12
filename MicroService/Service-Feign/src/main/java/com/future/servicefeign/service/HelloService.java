package com.future.servicefeign.service;

import com.future.servicefeign.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "service-allvpay-web", fallback = HelloServiceImpl.class)
public interface HelloService {

    @GetMapping("/hi")
    String hiService(@RequestParam(value = "name") String name);

    @PostMapping("feign")
    String pay(@RequestParam HttpServletRequest request);

    @PostMapping("payQuery")
    String payQuery(@RequestParam HttpServletRequest request);

}
