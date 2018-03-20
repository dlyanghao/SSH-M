package com.yanghao.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.yanghao.bean.Actor;
import com.yanghao.bean.Category;
import com.yanghao.bean.Course;
import com.yanghao.bean.Product;
import com.yanghao.bean.Student;
import com.yanghao.utils.HibernateUtil;

public class HibernateDemoTest {

	@Test
	public void test() {
		
		
		//使用hibernate操作数据库的步骤
		//读取配置文件,载入配置默认的配置文件
		Configuration configuration = new Configuration();
		configuration.configure();
		
		//创建SessionFactory获取Session对象
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		//执行数据库操作
		Actor actor = new Actor();
		actor.setName("黑妞");
		actor.setAge("2");
		actor.setBirthday("19920203");
		actor.setArea("繁荣山丘");
		session.save(actor);
		
		
		//提交事务
		transaction.commit();
		
		//关闭资源
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 使用工具类封装部分Hibernate操作
	 */
	@Test
	public void test2(){
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Actor actor = new Actor();
		actor.setName("皮蛋");
		actor.setAge("3");
		actor.setBirthday("19920203");
		actor.setArea("繁荣山丘");
		session.save(actor);
		
		transaction.commit();
		
		//关闭资源
		session.close();
	}
	
	//hibernate 持久态对象可以自动更新数据库
	//对于持久态的对象，当session中的一级缓存区中该对象发生改变，提交事务时，Hibernate就会比照缓存区和快照区中的对象，发现不一样就更新数据库
	@Test
	public void test3(){
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Actor actor = new Actor();
		actor.setName("皮蛋");
		actor.setAge("3");
		actor.setBirthday("20000101");
		actor.setArea("繁荣山丘");
		session.save(actor);
		transaction.commit();
		
		Transaction transaction2 = session.beginTransaction();
		actor.setAge("6");
		actor.setName("蛋皮");
		//session.update(actor);
		
		transaction2.commit();
		session.close();
	}
	
	@Test
	public void test4(){
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Actor actor = session.get(Actor.class, 2);
		System.out.println(actor);
		Actor actor2 = session.get(Actor.class, 3);
		System.out.println(actor2);
		
		transaction.commit();
		session.close();
	}
	
	//QBC查询
	//查询所有
	@Test
	public void test5(){
		
		Session currentSession = HibernateUtil.getCurrentSession();
		Transaction beginTransaction = currentSession.beginTransaction();
		Criteria createCriteria = currentSession.createCriteria(Actor.class);
		@SuppressWarnings("unchecked")
		List<Actor> list = createCriteria.list();
		System.out.println(list.toString());
		beginTransaction.commit();
		//currentSession.close();
	}
	
	//条件查询
	@Test
	public void test6(){
		
		Session currentSession = HibernateUtil.getCurrentSession();
		Transaction beginTransaction = currentSession.beginTransaction();
		Criteria createCriteria = currentSession.createCriteria(Actor.class);
		createCriteria.add(Restrictions.in("age", new Object[]{"1"}));
		@SuppressWarnings("unchecked")
		List<Actor> list = createCriteria.list();
		System.out.println(list.toString());
		beginTransaction.commit();
	}
	
	
	//一对多关系的级联保存(保存一方级联保存多方到表)
	@Test
	public void test7(){
		
		Session currentSession = HibernateUtil.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		
		Category category = new Category();
		category.setCname("水果");
		category.setCid(1);
		
	
		Product product = new Product();
		
		product.setPname("芒果");
		product.setNumber("10");
		product.setPrice("988");
		product.setCategory(category);
		
		Product product2 = new Product();
		product2.setPname("草莓");
		product2.setNumber("6");
		product2.setPrice("922");
		product2.setCategory(category);
		
		Set<Product> set = new HashSet<Product>();
		set.add(product);
		set.add(product2);

		
		category.setProducts(set);
		
		currentSession.save(category);
		transaction.commit();	
		
	}
	
	//多对一关系的级联保存(保存多方级联保存一方)
	@Test
	public void test8(){
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		
		
		Category category = new Category();
		category.setCname("水果");
		
		Product product = new Product();
		
		product.setPname("芒果");
		product.setNumber("10");
		product.setPrice("988");
		product.setCategory(category);
		
		
		Set<Product> set = new HashSet<Product>();
		set.add(product);
		category.setProducts(set);
		
		session.save(product);
		transaction.commit();
	}
	
	//删除一方级联删除多方（慎用）
	@Test
	public void test9(){
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = session.get(Category.class, 2);
		session.delete(category);
		
		transaction.commit();
	}
	
	
	//多方对多方(保存多的一方级联保存另一多方)
	@Test
	public void test10(){
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		Student student2 = new Student();
		Course course = new Course();
		Course course2 = new Course();
		student.setSname("杨豪");
		student2.setSname("胡熙");
		
		course.setCname("java");
		course2.setCname("python");
		HashSet<Course> set = new HashSet<Course>();
		HashSet<Student> set2 = new HashSet<Student>();
		set.add(course);
		set.add(course2);
		student.setCourses(set);
		student2.setCourses(set);
		
		set2.add(student);
		set2.add(student2);
		course.setStudents(set2);
		course2.setStudents(set2);
		
		session.save(course);
		session.save(course2);
		
		
		transaction.commit();
	}
	
	//HQL查询 HQL,Hibernate Query Language(Hibernate查询语言,语法与SQL类似,但是hql是面向对象的 ) 
	@Test
	public void test11(){
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select name from Actor where area like ?";
		Query createQuery = session.createQuery(hql);
		createQuery.setString(0, "_洲");
		createQuery.list();
		List<String> list = createQuery.list();
		for (String actor : list) {
			System.out.println(actor);
		}	
	}
	
	//HQL分组查询
	@Test
	public void test12(){
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select category.cid,count(*) from Product group by category.cid";
		
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		transaction.commit();
	}
	
	//QBC查询(Restriction--限定和约束)
	@Test
	public void test13(){
		
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria createCriteria = session.createCriteria(Product.class);
		Product pro = (Product) createCriteria.add(Restrictions.eq("pname", "西瓜")).uniqueResult();
		System.out.println(pro);
		
		transaction.commit();
	}
	
	
	
	
	
	
	
	
	
	
}
