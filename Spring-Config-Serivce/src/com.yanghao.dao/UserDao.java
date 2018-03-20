package com.yanghao.dao;

import com.yanghao.bean.User;

public interface UserDao {

    //用户登录
    public User login(User user) throws ClassNotFoundException;

    //用户注册
    public boolean regist(User user);

    //用户激活
    public boolean active();


}
