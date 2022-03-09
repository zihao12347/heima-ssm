package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

public interface SysLogDao {
    void saveLog(SysLog sysLog);

    List<SysLog> findAllSysLog();
}
