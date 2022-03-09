package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    /**
     *根据用户id删除用户角色中间表信息
     * @param id
     */
    void deleteByRid(String id);

    List<Role> findOtherRoles(String id);

    void addRoleToUser(@Param("userId") String userId,@Param("ids") String[] ids);
}
