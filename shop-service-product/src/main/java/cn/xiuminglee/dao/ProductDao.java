package cn.xiuminglee.dao;

import cn.xiuminglee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Xiuming Lee
 * @Description 使用JPA操作数据库
 * JpaRepository<Product,Long> ：实体类和主键的类型
 */
public interface ProductDao extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}
