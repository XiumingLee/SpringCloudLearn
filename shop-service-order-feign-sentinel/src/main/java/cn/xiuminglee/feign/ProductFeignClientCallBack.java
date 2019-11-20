package cn.xiuminglee.feign;

import cn.xiuminglee.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @Author Xiuming Lee
 * @Description
 */
@Component
public class ProductFeignClientCallBack implements ProductFeignClient {

    /**
     * 熔断降级的方法
     */
    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductName("feign调用触发熔断降级方法");
        return product;
    }
}
