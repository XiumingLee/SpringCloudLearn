package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class,args);
    }
}
