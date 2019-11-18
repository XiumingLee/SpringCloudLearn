package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication(scanBasePackages="cn.xiuminglee")
@EntityScan("cn.xiuminglee.entity")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
