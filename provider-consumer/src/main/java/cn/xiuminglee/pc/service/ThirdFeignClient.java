package cn.xiuminglee.pc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Xiuming Lee
 * @description
 */
@FeignClient(name="provider-other")
public interface ThirdFeignClient {
    /**
     * 配置需要调用的微服务接口
     */
    @RequestMapping(value="/po/testProviderOther",method = RequestMethod.GET)
    String testProviderOther();
}
