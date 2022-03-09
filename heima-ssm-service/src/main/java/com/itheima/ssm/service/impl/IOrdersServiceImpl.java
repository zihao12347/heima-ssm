package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class IOrdersServiceImpl implements IOrdersService {
    private IOrdersDao iOrdersDao;
    public List<Orders> findAll(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<Orders> ordersList = this.iOrdersDao.findAll();
        return ordersList;
    }

    /**
     * 根据订单id查询订单详情
     * @param id
     * @return
     */
    @Override

    public Orders findById(String id) {
        Orders orders=this.iOrdersDao.findById(id);
        return orders;
    }
}
