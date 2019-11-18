package cn.xiuminglee.service;

import cn.xiuminglee.entity.Product;

import java.util.List;

/**
 * @Author Xiuming Lee
 * @Description
 */
public interface ProductService {

    /**
     * 查询全部
     */
    List findAll();

    /**
     * 根据id查询
     */
    Product findById(Long id);

    /**
     * 保存
     */
    void save(Product product);
    /**
     * 更新
     */
    void update(Product product);
    /**
     * 删除
     */
    void delete(Long id);
}
