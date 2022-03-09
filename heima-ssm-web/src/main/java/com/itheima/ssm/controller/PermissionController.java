package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
@AllArgsConstructor
public class PermissionController {
    private IPermissionService iPermissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions=this.iPermissionService.findAll();
        modelAndView.addObject("permissionList",permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){
        this.iPermissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true) String id){
        this.iPermissionService.deleteById(id);
        return "redirect:findAll.do";
    }
}
