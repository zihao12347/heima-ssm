package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles; //角色和权限是多对多关系
}
