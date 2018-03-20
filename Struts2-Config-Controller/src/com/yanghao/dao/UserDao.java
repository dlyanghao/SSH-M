package com.yanghao.dao;

import com.yanghao.bean.User;
import com.yanghao.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao {


    public boolean login(User user){

        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username",user.getUsername()))
                .add(Restrictions.eq("password",user.getPassword()));
        Object o = criteria.uniqueResult();
        if(o != null) {
            return true;
        }
        else{
            return false;
        }
    }
}
