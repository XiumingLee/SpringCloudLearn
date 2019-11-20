package cn.xiuminglee;

import cn.xiuminglee.exception.ExceptionUtils;
import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EntityScan("cn.xiuminglee.entity")
public class OrderRestSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderRestSentinelApplication.class,args);
    }


    /**
     * sentinel支持对restTemplate的服务调用使用sentinel方法.在构造
     *  RestTemplate对象的时候,只需要加载@SentinelRestTemplate即可
     *
     *  资源名:
     *       httpmethod:schema://host:port/path ：协议、主机、端口和路径
     *       httpmethod:schema://host:port ：协议、主机和端口
     *
     *  @SentinelRestTemplate:
     *    异常降级
     *      fallback      : 降级方法
     *      fallbackClass : 降级配置类
     *    限流熔断
     *      blockHandler
     *      blockHandlerClass
     */
    @LoadBalanced
    @Bean
    @SentinelRestTemplate(fallbackClass = ExceptionUtils.class,fallback = "handleFallback",
            blockHandler = "handleBlock" ,blockHandlerClass = ExceptionUtils.class
    )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
