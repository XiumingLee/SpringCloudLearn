package cn.xiuminglee;

import cn.xiuminglee.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Xiuming Lee
 * @Description 测试类
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderApplicationTest {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test(){
        // //根据微服务名称从注册中心获取相关的元数据信息
        List<ServiceInstance> instances = discoveryClient.getInstances("shop-service-product");
        String url = "http://" + instances.get(0).getHost() + ":" + instances.get(0).getPort() + "/product/1";
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println("------------------");
        System.out.println(product);
        System.out.println("------------------");
    }
}
