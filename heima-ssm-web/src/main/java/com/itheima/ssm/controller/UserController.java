package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private IUserService iUserService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = this.iUserService.findAll();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userInfoList);
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        this.iUserService.save(userInfo);
        return "redirect:findAll.do";//新增完成之后,查询用户信息
    }

    /**
     * 查询用户详情信息
     * @return
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo=this.iUserService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 根据用户id查询用户，并且可用给用户添加角色信息
     * @param id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id" ,required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //1.根据用户id查询用户信息
        UserInfo userInfo=this.iUserService.findById(id);
        //2.根据用户id查询该用户可用添加的角色：
        List<Role> roles=this.iUserService.findOtherRoles(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",roles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,
                                @RequestParam(name = "ids",required = true) String[] ids){
            this.iUserService.addRoleToUser(userId,ids);
            return "redirect:findAll.do";
    }
}
