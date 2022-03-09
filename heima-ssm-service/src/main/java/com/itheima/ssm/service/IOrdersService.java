package com.itheima.ssm.service;

import com.github.pagehelper.Page;
import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public  List<Orders>findAll(Integer page, Integer size);

    Orders findById(String id);
}
