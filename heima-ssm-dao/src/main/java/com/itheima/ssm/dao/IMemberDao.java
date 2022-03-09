package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;

public interface IMemberDao {
    Member findById(String id);
}
