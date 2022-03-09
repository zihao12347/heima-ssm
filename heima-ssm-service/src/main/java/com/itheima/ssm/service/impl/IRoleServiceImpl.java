package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.dao.PermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class IRoleServiceImpl implements IRoleService {
    private IRoleDao iRoleDao;
    private IUserDao iUserDao;
    private PermissionDao permissionDao;

    @Override
    public List<Role> findAll() {
        List<Role> roles = this.iRoleDao.findAll();
        return roles;
    }

    @Override
    public void save(Role role) {
        this.iRoleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        Role role = this.iRoleDao.findById(id);
        return role;
    }

    /**
     * 删除角色信息:
     * 注意:删除角色信息还需要删除角色关联的用户中间表信息,角色关联的权限中间表信息
     * 根据角色id删除角色信息:----根据角色id删除角色表
     * 用户和角色为多对多关系----根据角色id删除用户角色中间表相关信息
     * 角色和权限为多对多关系----根据角色id删除角色权限中间表相关信息
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        this.iUserDao.deleteByRid(id);//删除用户角色中间表中的数据
        this.iRoleDao.delete(id);//删除角色表信息
        this.permissionDao.deleteByRid(id);//删除角色权限中间表中的数据
    }

    /**
     * 根据角色id查询当前角色可以添加哪些权限，
     * 可添加的权限：查询当前权限不在哪个用户角色表中，
     *
     * @param rid
     * @return
     */
    public List<Permission> findOtherPermissions(String rid) {
        List<Permission> permissions = this.permissionDao.findOtherPermissions(rid);
        return permissions;
    }

    /**
     * 给当前角色添加权限
     * @param roleId
     * @param ids
     */
    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        this.permissionDao.addPermissionToRole(roleId,ids);
    }
}
