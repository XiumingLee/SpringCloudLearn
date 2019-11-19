package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Xiuming Lee
 * @Description
 */
@EntityScan("cn.xiuminglee.entity")
@SpringCloudApplication
public class OrderRestHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderRestHystrixApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
