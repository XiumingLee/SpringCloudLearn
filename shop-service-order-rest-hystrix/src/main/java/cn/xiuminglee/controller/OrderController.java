package cn.xiuminglee.controller;

import cn.xiuminglee.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Xiuming Lee
 * @Description
 */
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 使用注解配置熔断保护
     *     fallbackmethod : 配置熔断之后的降级方法
     */
    //@HystrixCommand(fallbackMethod = "orderFallBack")
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = restTemplate.getForObject("http://shop-service-product/product/1", Product.class);;
        return product;
    }

    /**
     * 降级方法
     *  和需要收到保护的方法的返回值一致
     *  方法参数一致
     */
    public Product orderFallBack(Long id) {
        Product product = new Product();
        product.setProductName("熔断：触发降级方法");
        return product;
    }


    /**
     * 指定统一的降级方法
     *  * 参数 : 没有参数
     */
    public Product defaultFallBack() {
        Product product = new Product();
        product.setProductName("触发统一的降级方法");
        return product;
    }
}
