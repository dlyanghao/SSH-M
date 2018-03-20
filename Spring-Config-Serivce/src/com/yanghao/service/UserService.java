package com.yanghao.service;

import com.yanghao.bean.User;

public interface UserService {

    //用户登录服务
    public User loginService(User user) throws ClassNotFoundException;

    //用户注册服务
    public boolean registService(User user);

    //用户激活服务
    public boolean activeService();


}
