package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional  //事务管理
@AllArgsConstructor //构造器实现，注入IProductDao
public class IProductServiceImpl implements IProductService {

    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() {
        List<Product> productList = this.iProductDao.findAll();
        return productList;
    }


    @Override
    public void save(Product product) {
        this.iProductDao.save(product);
    }
}
