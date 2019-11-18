package cn.xiuminglee.controller;

import cn.xiuminglee.entity.Product;
import cn.xiuminglee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Xiuming Lee
 * @Description
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List findAll() {
        return productService.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = productService.findById(id);
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
