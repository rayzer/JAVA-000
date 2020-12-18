package com.ray.lab.controller;

import com.ray.lab.service.TradingServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TradingController {
    @Resource
    private TradingServiceImpl tradingService;

    @GetMapping("/tcc")
    public String tcc(){
        tradingService.trade();
        return "success";
    }

}
