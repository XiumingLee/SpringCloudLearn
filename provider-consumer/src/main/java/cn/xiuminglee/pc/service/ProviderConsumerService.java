package cn.xiuminglee.pc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Xiuming Lee
 * @description：由于这里是网关做代理，所以微服务名称填写网关的名称
 */
@FeignClient(name="gateway")
public interface ProviderConsumerService {
    /**
     * 配置需要调用的微服务接口
     */
    @RequestMapping(value="/provider-other/po/testProviderOther",method = RequestMethod.GET)
    String testProviderOther();
}
