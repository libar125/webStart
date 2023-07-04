package com.qing.api.component;


import com.qing.api.service.impl.MemberOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author libarAdministrator
 */
@Component
public class CancelOrderTask {
    @Autowired
    MemberOrderServiceImpl memberOrderService;

    /**
     * 60s执行一次
     */
    @Scheduled(cron="0/60 * *  * * ? ")
    public void execute(){
        memberOrderService.cancelMemberOrder();
    }
}
