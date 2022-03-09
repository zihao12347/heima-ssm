package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findAll();

    void save(Product product);

    Product findById(String id);
}
