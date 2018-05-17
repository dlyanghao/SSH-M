package com.yanghao.test;

import com.yanghao.dao.OrdersDao;
import com.yanghao.dao.UserDao;
import com.yanghao.pojo.Orders;
import com.yanghao.pojo.User;
import com.yanghao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 测试OrdersDao
 */
public class OrdersDaoTest {

    @Test
    public void getOrdersWithUserTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        OrdersDao mapper = sqlSession.getMapper(OrdersDao.class);
        List<Orders> orders = mapper.getOrdersWithUser();
        for (Orders order: orders
             ) {
            System.out.println(order);
            System.out.println(order.getUser());
        }


    }
}
