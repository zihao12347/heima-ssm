package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {
    public void saveLog(SysLog sysLog);

    List<SysLog> findAllSysLog();
}
