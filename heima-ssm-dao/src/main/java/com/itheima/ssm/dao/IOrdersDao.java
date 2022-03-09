package com.itheima.ssm.dao;

import com.github.pagehelper.Page;
import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrdersDao {
    public List<Orders> findAll();

    Orders findById(String id);
}
