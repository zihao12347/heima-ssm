package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    /**
     * 根据角色id值查询权限数据
     * @param id
     * @return
     */
    public List<Permission> findByRid(String id);

    List<Permission> findAll();

    /**
     * 根据角色id删除角色权限中间表信息
     * @param id
     */
    void deleteByRid(String id);

    void save(Permission permission);

    void deleteById(String id);

    List<Permission> findOtherPermissions(String rid);

    void addPermissionToRole(@Param("roleId") String roleId,@Param("ids") String[] ids);
}
