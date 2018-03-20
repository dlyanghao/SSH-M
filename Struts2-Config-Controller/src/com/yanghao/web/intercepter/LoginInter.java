package com.yanghao.web.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class LoginInter extends MethodFilterInterceptor{
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("进入了登录拦截器");

        HttpServletRequest request = ServletActionContext.getRequest();

        if(request.getSession().getAttribute("user")!=null)
        {
            actionInvocation.invoke();
            return null;
        }
        else {
            return "noLogin";
        }

    }
}
