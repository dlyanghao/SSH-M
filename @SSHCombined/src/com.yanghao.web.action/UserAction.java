package com.yanghao.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction extends ActionSupport implements ModelDriven<User>{

    //通过struts模型驱动注入
    private User user;
    //Spring依赖注入
    @Autowired
    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String saveUserAction(){
        userService.saveUserService(user);
        return SUCCESS;
    }


    @Override
    public User getModel() {
        if(user==null)
        {
            user = new User();
        }
        return user;
    }
}
