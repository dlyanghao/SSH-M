package com.yanghao.anno.service;

import com.yanghao.anno.bean.User;
public interface UserService {

    //用户登录服务
    public User loginService();

    //用户注册服务
    public boolean registService();

    //用户激活服务
    public boolean activeService();


}
