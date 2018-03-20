package com.yanghao.service;

import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import com.yanghao.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {

    //登录服务
    public boolean loginService(User user){

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        boolean flag = new UserDao().login(user);

        transaction.commit();
        return flag;

    }
}
