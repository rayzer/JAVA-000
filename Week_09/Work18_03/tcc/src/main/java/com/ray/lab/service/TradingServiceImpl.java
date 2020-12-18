package com.ray.lab.service;


import com.ray.lab.entity.Account;
import org.dromara.hmily.annotation.HmilyTCC;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class TradingServiceImpl implements TradingService {
    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private AccountServiceA accountServiceA;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12346")
    private AccountServiceB accountServiceB;

    @HmilyTCC(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public void trade() {
        accountServiceA.updateDollar(Account.builder().userId(1).money(0).build());
        accountServiceA.updateRMB(Account.builder().userId(1).money(7).build());

        accountServiceB.updateDollar(Account.builder().userId(2).money(1).build());
        accountServiceB.updateRMB(Account.builder().userId(2).money(0).build());
    }

    public void confirmOrder() {
        System.out.println("Order confirmed");
    }

    public void cancelOrder() {
        System.out.println("Order cancelled");
    }
}
