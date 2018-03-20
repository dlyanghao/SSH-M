package com.yanghao.serviceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import com.yanghao.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean saveUserService(User user) {
        return userDao.saveUser(user);
    }

    public void test(){


        ActionContext context = ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
    }

}
