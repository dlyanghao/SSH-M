package com.yanghao.serviceimpl;

import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import com.yanghao.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //要对loginService方法进行增强,在不改变方法代码的情况下进行，使用面向切面编程思想AOP
    @Override
    public User loginService(User user) throws ClassNotFoundException {
        //出现需要增强该方法的需求
        return userDao.login(user);
    }

    //使用事务来管理当前注册操作（编程式事务：代码）,或者使用声明式事务（xml配置或者注解）
    @Override
    public boolean registService(User user) {
        return userDao.regist(user);
    }

    @Override
    public boolean activeService() {
        return userDao.active();
    }
}
