package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.PermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class IPermissionServiceImpl implements IPermissionService {
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        List<Permission>permissions=this.permissionDao.findAll();
        return permissions;
    }

    @Override
    public void save(Permission permission) {
        this.permissionDao.save(permission);
    }

    @Override
    public void deleteById(String id) {
        this.permissionDao.deleteById(id);
    }
}
