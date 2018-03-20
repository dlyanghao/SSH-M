package com.yanghao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 工具类（提供Session对象，全局中只有一个SessionFactory）
 * HibernateUtil
 * @author YanoHao
 * 
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	
	static {
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	//私有构造方法,不能通过构造方法创建对象
	private HibernateUtil(){
		
	}
		
	//获取新的Session对象
	public static Session getSession(){
		
		Session session = sessionFactory.openSession();
		return session;
	
	}
	
	//获取当前线程中唯一的Session对象
	public static Session getCurrentSession(){
		
		return sessionFactory.getCurrentSession();
	}		
}
