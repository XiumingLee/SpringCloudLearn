package cn.xiuminglee.controller;

import cn.xiuminglee.entity.Product;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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

    @Autowired
    private RestTemplate restTemplate;


    /**
     * @SentinelResource
     *      blockHandler : 声明熔断时调用的降级方法
     *      fallback : 抛出异常执行的降级方法
     *      value : 自定义的资源名称
     *          * 不设置:当前全类名.方法名
     */
    @SentinelResource(value="orderFindById",blockHandler = "orderBlockHandler",fallback = "orderFallback")
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = restTemplate.getForObject("http://shop-service-product/product/" + id, Product.class);
        return product;
    }

    /**
	 * 定义降级逻辑
	 *  hystrix和sentinel
	 *      熔断执行的降级方法
	 *      抛出异常执行的降级方法
	 */
	public Product orderBlockHandler(Long id) {
		Product product = new Product();
		product.setProductName("触发熔断的降级方法");
		return product;
	}

	public Product orderFallback(Long id) {
		Product product = new Product();
		product.setProductName("抛出异常执行的降级方法");
		return product;
	}
}
