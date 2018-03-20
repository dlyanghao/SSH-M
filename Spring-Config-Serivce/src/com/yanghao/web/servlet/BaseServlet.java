package com.yanghao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @SuppressWarnings("all")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //通过请求参数获取要调用的方法名
        String methodName = req.getParameter("method");

        //使用反射调用当前类子类的相应的方法
        //获取当前类子类的字节码对象
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method = aClass.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);

            if(method!=null)
            method.invoke(this,req,resp);
        } catch (Exception e) {
            System.out.println("Servlet方法请求不成功！");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
