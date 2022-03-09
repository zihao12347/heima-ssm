package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * 根据用户表id值查询角色表
     * @param id
     * @return
     */
    public List<Role> findByUid(String id);

    List<Role> findAll();

    void save(Role role);

    /**
     * 根据角色id查询角色信息及权限信息
     * @param id
     * @return
     */
    Role findById(String id);

    void delete(String id);
}
