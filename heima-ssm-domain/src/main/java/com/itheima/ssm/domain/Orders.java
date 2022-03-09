package com.itheima.ssm.domain;

import com.itheima.utils.ssm.DateUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private int peopleCount;
    private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private String orderDesc;

    public String getOrderStatusStr() {
        if (orderStatus ==0) {
            orderStatusStr="未支付";
        } else if (orderStatus ==1) {
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if (payType != null) {
            if (payType == 0) {
                payTypeStr="支付宝";
            }else if (payType == 1) {
                payTypeStr="微信";
            }else if (payType == 2) {
                payTypeStr="其它";
            }
        }
        return payTypeStr;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr= DateUtils.DateToString(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    private Product product; //商品表：多对一关系
    private List<Traveller> travellers;//游客表：多对多关系
    private Member member;//会员表，多对一关系
}
