package cn.xiuminglee.pc.controller;

import cn.xiuminglee.pc.service.ProviderConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiuming Lee
 * @description
 */
@RestController
@RequestMapping("/pc")
public class ProviderConsumer {

    @Autowired
    ProviderConsumerService providerConsumerService;

    @RequestMapping("/test")
    public String test(){
        return "我是ProviderConsumerApplication的ProviderConsumer#test 方法！";
    }

    @RequestMapping("/testProviderOther")
    public String testProviderOther(){
        return providerConsumerService.testProviderOther();
    }
}
