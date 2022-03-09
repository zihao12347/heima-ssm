package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUserService {
    public List<UserInfo> findAll();
    public void save(UserInfo userInfo);

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] ids);
}
