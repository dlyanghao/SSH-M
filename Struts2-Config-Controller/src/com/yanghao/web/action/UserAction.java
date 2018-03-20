package com.yanghao.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAction extends ActionSupport{

    //该user对象的实例由Struts2创建并封装，属性驱动自动完成(由请求参数user.username---本质是调用getUser方法,再调用getUsername方法)
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    public String login(){

        System.out.println("请求成功");
        System.out.println(user.toString());

        //请求登录服务
        boolean flag = new UserService().loginService(user);

        if(flag) {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "loginSuccess";
        }
        else {
            return "loginFail";
        }
    }
}
