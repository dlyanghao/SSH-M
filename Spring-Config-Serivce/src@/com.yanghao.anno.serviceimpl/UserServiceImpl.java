package com.yanghao.anno.serviceimpl;


import com.yanghao.anno.bean.User;
import com.yanghao.anno.dao.UserDao;
import com.yanghao.anno.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loginService() {
        return userDao.login();
    }

    @Override
    public boolean registService() {
        return userDao.regist();
    }

    @Override
    public boolean activeService() {
        return userDao.active();
    }
}
