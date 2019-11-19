package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EntityScan("cn.xiuminglee.entity")
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class OrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplication.class,args);
    }
}
