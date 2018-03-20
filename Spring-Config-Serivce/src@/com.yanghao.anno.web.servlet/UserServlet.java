package com.yanghao.anno.web.servlet;


import com.yanghao.anno.bean.User;
import com.yanghao.anno.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends BaseServlet {

    public void login(HttpServletRequest request, HttpServletResponse response){

        //获取Spring创建的工厂对象(工厂在服务器启动时已经创建完成)
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

        //使用工厂获取Bean对象
        UserService uService = (UserService) webApplicationContext.getBean("uService");
        User user = uService.loginService();

        System.out.println(user);
    }

    public void register(HttpServletRequest request, HttpServletResponse response){

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

        UserService uService = (UserService)context.getBean("uService");
        boolean result = uService.registService();

        if(result){
            System.out.println("注册成功！");
        }

    }

}
