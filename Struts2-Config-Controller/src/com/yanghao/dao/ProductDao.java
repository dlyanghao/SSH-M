package com.yanghao.dao;

import com.yanghao.bean.Product;
import com.yanghao.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDao {

    public List<Product> getProducts() {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //创建QBC查询当前所有的产品信息
        Criteria criteria = session.createCriteria(Product.class);
        List<Product> list = criteria.list();

        transaction.commit();
        //返回当前的list
        return list;
    }
}
