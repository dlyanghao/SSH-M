package com.yanghao.daoImpl;

import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * HibernateDapSupport 里有一个sessionFactory变量；要注入该对象才能调用模板对象
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    @Override
    public boolean saveUser(User user) {

        this.getHibernateTemplate().save(user);
        return false;
    }
}
