package com.itheima.ssm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统日志实体类
 */
@Data
public class SysLog {
    private String id; //主键
    private Date visittime; //访问时间
    private String visittimeStr;
    private String username;    //访问用户名
    private String ip;  //访问ip
    private String url; //访问资源的url
    private Long executiontime; //执行时间
    private String method;  //访问方法

    public SysLog() {
    }

    public String getVisittimeStr() {
        if (visittime != null&&!"".equals(visittime)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            visittimeStr=format.format(visittime.getTime());
        }
        return visittimeStr;
    }

    public void setVisittimeStr(String visittimeStr) {
        this.visittimeStr = visittimeStr;
    }

    public SysLog(Date visittime, String username, String ip, String url, Long executiontime, String method) {
        this.visittime = visittime;
        this.username = username;
        this.ip = ip;
        this.url = url;
        this.executiontime = executiontime;
        this.method = method;
    }
}
