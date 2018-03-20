package com.yanghao.anno.daoimpl;

import com.yanghao.anno.bean.User;
import com.yanghao.anno.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @SuppressWarnings("all")
    @Override
    public User login() {
        //模拟从数据库中获取数据对象
        User user = new User();
        user.setUsername("yanghao");
        user.setPassword("123456");
        user.setEmail("369000246@qq.com");
        return user;
    }

    @Override
    public boolean regist() {
        return false;
    }

    @Override
    public boolean active() {
        return false;
    }
}
