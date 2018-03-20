package com.yanghao.anno.test;


import com.yanghao.anno.bean.User;
import com.yanghao.anno.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Spring扩展了junit的运行环境，除了有测试功能之外，还在里面定义了创建工厂的代码,该注解是JUnit的注解
@RunWith(SpringJUnit4ClassRunner.class)
//配置当前Spring测试环境的配置文件
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class SpringTest {

    //当前测试类里面出现的注解，不用开启注解扫描开关。因为这个测试环境里面，它会解析这个测试类的注解。

    @Autowired
    private UserService userService;


    @Test
    public void Test(){

        User user = userService.loginService();
        System.out.println(user);
    }

}
