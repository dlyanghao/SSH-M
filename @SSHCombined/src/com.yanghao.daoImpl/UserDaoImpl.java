package com.yanghao.daoImpl;

import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * HibernateDapSupport 里有一个sessionFactory变量；要注入该对象才能调用模板对象
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public boolean saveUser(User user) {

        this.getHibernateTemplate().save(user);
        return false;
    }

    /**
     * 如果想注入一个父类的私有属性而又无法对父类进行注解的时候
     * @PostConstruct，这个方法会在Bean初始化之后被Spring容器执行
     */
    @PostConstruct
    public void injectSessionFactory(){
        super.setSessionFactory(factory);
    }
}
