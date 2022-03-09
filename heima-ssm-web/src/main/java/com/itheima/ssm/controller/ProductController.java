package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /**
     *查询所有订单
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Product> productList = this.iProductService.findAll();
        productList.forEach(System.out::println);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 产品新增
     */
    @RequestMapping("/save.do")
    public String save(Product product){
        System.out.println(product);
        this.iProductService.save(product);
        return "redirect:findAll.do"; //当新增完成，重新调用查询所有方法
    }
}
