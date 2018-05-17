package com.yanghao.dao;

import com.yanghao.pojo.Orders;

import java.util.List;

public interface OrdersDao {

    /**
     * 获取所有的订单信息包含当前拥有订单的用户
     */
    public List<Orders> getOrdersWithUser();


}
