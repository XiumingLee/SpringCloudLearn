package cn.xiuminglee.controller;

import cn.xiuminglee.entity.Product;
import cn.xiuminglee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Xiuming Lee
 * @Description
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    /** spring cloud 自动的获取当前应用的ip地址 */
    @Value("${spring.cloud.client.ip-address}")
    private String ip;


    @Autowired
    private ProductService productService;

    @GetMapping
    public List findAll() {
        return productService.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        product.setProductName("访问的服务地址:"+ip + ":" + port);
        return product;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "保存成功";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Product product) {
        productService.update(product);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(Long id) {
        productService.delete(id);
        return "删除成功";
    }
}
