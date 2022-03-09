package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    void delete(String id);

    List<Permission> findOtherPermissions(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
