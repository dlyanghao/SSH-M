package com.yanghao.web.servlet;

import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends BaseServlet{

    public void login(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {

        //获取Spring创建的工厂对象(工厂在服务器启动时已经创建完成)
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

        //使用Spring的IOC容器（工厂）获取Bean对象
        UserService uService = (UserService) webApplicationContext.getBean("uService");

        //从前端获取到的数据封装成User对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User currentUser = new User();
        currentUser.setUsername(username);
        currentUser.setPassword(password);
        User user = uService.loginService(currentUser);

        System.out.println(user);

    }

    public void register(HttpServletRequest request, HttpServletResponse response){

        //获取Spring创建的工厂对象(工厂在服务器启动时已经创建完成)
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

        //使用Spring的IOC容器（工厂）获取Bean对象
        UserService uService = (UserService) webApplicationContext.getBean("uService");

        //从前端获取到的数据封装成User对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User currentUser = new User();
        currentUser.setUsername(username);
        currentUser.setPassword(password);

        boolean flag = uService.registService(currentUser);
        if(flag){
            System.out.println("注册成功");
        }
        else {
            System.out.println("注册失败");
        }

    }

}
