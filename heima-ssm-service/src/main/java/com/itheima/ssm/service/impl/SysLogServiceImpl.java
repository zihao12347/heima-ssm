package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.SysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class SysLogServiceImpl implements SysLogService {
    private SysLogDao sysLogDao;
    /**
     * 保存日志处理信息到数据中
     * @param sysLog
     */
    @Override
    public void saveLog(SysLog sysLog) {
        this.sysLogDao.saveLog(sysLog);
    }

    @Override
    public List<SysLog> findAllSysLog() {
        List<SysLog> sysLogs=this.sysLogDao.findAllSysLog();
        return sysLogs;
    }
}
