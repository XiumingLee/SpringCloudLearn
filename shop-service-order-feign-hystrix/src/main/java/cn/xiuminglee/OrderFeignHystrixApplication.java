package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EntityScan("cn.xiuminglee.entity")
@EnableFeignClients
public class OrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplication.class,args);
    }
}
