package cn.xiuminglee.pc.controller;

import cn.xiuminglee.pc.service.ProviderConsumerService;
import cn.xiuminglee.pc.service.ThirdFeignClient;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
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

    @Autowired
    ThirdFeignClient thirdFeignClient;

    @RequestMapping("/test")
    public String test(){
        return "我是ProviderConsumerApplication的ProviderConsumer#test 方法！";
    }

    @RequestMapping("/testProviderOther")
    public String testProviderOther(){
        return providerConsumerService.testProviderOther();
    }

    /**
     * Nacos手动注册第三方服务
     * @return
     */
    @RequestMapping("/registerThirdPartyServer")
    public String registerThirdPartyServer() throws NacosException {
        NamingService naming = NamingFactory.createNamingService("localhost:8848");
        naming.registerInstance("provider-other", "127.0.0.1", 8091);
        return "手动注册服务成功！";
    }
    @RequestMapping("/testProviderOther2")
    public String testProviderOther2(){
        return thirdFeignClient.testProviderOther();
    }
}
