package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    private IUserDao iUserDao;
    private IRoleDao iRoleDao;
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = this.iUserDao.findAll();
        return userInfoList;
    }

    @Override
    public void save(UserInfo userInfo) {
        this.iUserDao.save(userInfo);
    }

    /**
     * 查询用户详情信息
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id) throws Exception {
        UserInfo userInfo=this.iUserDao.findById(id);
        return userInfo;
    }

    /**
     * 根据用户id查询该用户可添加的角色信息：
     * @param id
     * @return
     */
    @Override
    public List<Role> findOtherRoles(String id) {
        List<Role> roles=this.iUserDao.findOtherRoles(id);
        return roles;
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     */
    @Override
    public void addRoleToUser(String userId, String[] ids) {
        this.iUserDao.addRoleToUser(userId,ids);
    }
}
