package com.yanghao.test;

import com.yanghao.mapper.UserMapper;
import com.yanghao.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    private ApplicationContext context;
    @Before
    public void before(){

        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    }
    @Test
    public void test(){
        UserMapper mapper = context.getBean(UserMapper.class);
        User user = mapper.selectByPrimaryKey(new Integer(1));
        System.out.println(user);
    }

}
