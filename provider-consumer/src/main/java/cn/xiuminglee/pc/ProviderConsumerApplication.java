package cn.xiuminglee.pc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProviderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderConsumerApplication.class, args);
    }

}
