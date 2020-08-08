package cn.xiuminglee.providerother.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiuming Lee
 * @description
 */
@RestController
@RequestMapping("/po")
public class ProviderOtherController {

    @RequestMapping("/testProviderOther")
    public String testProviderOther(){
        return "我是其他的服务提供者，我们没有注册到服务中心！！";
    }
}
