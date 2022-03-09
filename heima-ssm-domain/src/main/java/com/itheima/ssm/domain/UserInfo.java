package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr; //状态0 未开启 1 开启
    private List<Role> roles;//用户和角色：多对多关系

    public String getStatusStr() {
        if (status == 1) {
            statusStr="开启";
        } else if (status == 0) {
            statusStr="未开启";
        }
        return statusStr;
    }
}
