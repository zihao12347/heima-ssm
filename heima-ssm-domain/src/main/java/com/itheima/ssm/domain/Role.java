package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;


@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions; //角色和权限：多对多关系
    private List<UserInfo> users; //角色和用户：多对多关系
}
