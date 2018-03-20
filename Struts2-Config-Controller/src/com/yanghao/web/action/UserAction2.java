package com.yanghao.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAction2 extends ActionSupport implements ModelDriven<User>{


    private User user;



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

    /**
     * 该方法要求返回一个非空的对象
     * @return
     */
    @Override
    public User getModel() {
        if(user == null)
        {
            user = new User();
        }
        return user;
    }
}
