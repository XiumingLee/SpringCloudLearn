package cn.xiuminglee.controller;

import cn.xiuminglee.entity.Product;
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
public class OrderController {
    /** 注入restTemplate对象 */
    @Autowired
    private RestTemplate restTemplate;


    /**
     * 使用restTemplate的远程调用
     */
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = null;
        //product = restTemplate.getForObject("http://localhost:9011/product/1",Product.class);
        product = restTemplate.getForObject("http://shop-service-product/product/1",Product.class);
        return product;
    }
}
