package com.yanghao.test;

import com.yanghao.dao.UserDao;
import com.yanghao.pojo.Orders;
import com.yanghao.pojo.User;
import com.yanghao.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * 测试UserDao
 */
public class UserDaoTest {

    @Test
    public void addUserTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("yanghao4");
        user.setPassword("1234564");
        user.setEmail("3690002464@qq.com");
        int i = mapper.addUser(user);
        System.out.println("在一个会话中获取当前插入记录的主键："+i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delUserTest(){

        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.delUser(2);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        sqlSession.close();
        System.out.println(user);

    }


    @Test
    public void getUserByNameTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.getUserByName("%yang%");
        sqlSession.close();
        for (User user: users
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserByNameAndEmail(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("yanghao");
        user.setEmail("369000246@qq.com");
        List<User> users = mapper.getUsersByNameAndEmail(user);
        for (User tem: users
                ) {
            System.out.println(tem);
        }
    }

    @Test
    public void getUserWithOrders(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.getUserWithOrders(2);

        for (User tem: users
                ) {
            System.out.println(tem);
            for (Orders order: tem.getList()
                 ) {
                System.out.println(order);
            }
        }
    }


    @Test
    public void getUsersTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.getUsers();
        sqlSession.close();
        for (User user:users
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setUsername("yanghao");
        user.setPassword("123456");
        user.setEmail("369000246@qq.com");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

}
