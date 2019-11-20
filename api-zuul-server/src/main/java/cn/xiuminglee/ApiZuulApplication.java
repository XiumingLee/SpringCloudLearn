package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiZuulApplication.class,args);
    }
}
