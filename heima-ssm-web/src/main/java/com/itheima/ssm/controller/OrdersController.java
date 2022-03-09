package com.itheima.ssm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {
    private IOrdersService iOrdersService;

    /**
     * 查询订单所有方法
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(name = "size",defaultValue = "5",required = true) Integer size){
        List<Orders> ordersList = this.iOrdersService.findAll(page, size);
        //分页参数类：定义了分页结果信息
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    /**
     * 根据订单id查询订单详情
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Orders orders=this.iOrdersService.findById(id);
        System.out.println(orders);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
