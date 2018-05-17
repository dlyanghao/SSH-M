package com.yanghao.dao;

import com.yanghao.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 添加一个用户
     * @param user
     */
    public int addUser(User user);

    /**
     * 根据id删除一个用户
     * @param id
     */
    public void delUser(int id);

    /**
     * 根据用户的Id获取用户对象
     * @param id
     * @return
     */
    public User getUserById(int id);


    /**
     * 根据名称进行模糊查询
     * @param likeName
     * @return
     */
    public List<User> getUserByName(String likeName);

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getUsers();

    /**
     * 根据用户的名称和邮箱获取当期的用户
     * @param user
     * @return
     */
    public List<User> getUsersByNameAndEmail(User user);

    /**
     * 根据当前的id查询用户信息以及用户所拥有的订单
     * @param id
     * @return
     */
    public List<User> getUserWithOrders(int id);

    /**
     * 根据Id更新当前用户
     * @param user
     */
    public void updateUser(User user);





}
