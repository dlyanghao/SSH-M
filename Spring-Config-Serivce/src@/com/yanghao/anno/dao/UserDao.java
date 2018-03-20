package com.yanghao.anno.dao;

import com.yanghao.anno.bean.User;

public interface UserDao {

    //用户登录
    public User login();

    //用户注册
    public boolean regist();

    //用户激活
    public boolean active();


}
