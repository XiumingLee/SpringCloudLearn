package cn.xiuminglee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Xiuming Lee
 * @Description
 */
@SpringBootApplication
@EntityScan("cn.xiuminglee.entity")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    /**
     * 注入restTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
