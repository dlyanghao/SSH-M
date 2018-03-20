package com.yanghao.daoimpl;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yanghao.bean.User;
import com.yanghao.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao{


    private JdbcTemplate jdbcTemplate;

    private TransactionTemplate transactionTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @SuppressWarnings("all")
    @Override
    public User login(User user) throws ClassNotFoundException {
        //Spring对Dao层提供了各种模板技术的支持
        //使用Spring对JDBC支持的模板来进行login操作

        //使用Spring模板的注入写法来代替当前对象的创建操作
        /**
         * 1创建数据源对象(C3p0包下的数据源管理者提供的数据源（提供Connenction）,没有用其连接池来提供连接对象)
         * 2给数据源对象设置连接参数(使用JDBC技术来操作数据库)
         * 3使用Spring提供的jdbc模板类通过数据源来操作数据库
         */
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUser("root");
//        dataSource.setPassword("7773365");
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql:///test");

        //通过Spring的IOC容器实例化工厂并自动注入属性值可以省去创建对象和设置参数的工作
//        jdbcTemplate.setDataSource(driverManagerDataSource);

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        //使用jdbc模板查出的数据还要自己封装数据对象，显得稍微麻烦
        User currentUser = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                User currentUser = new User();
                currentUser.setUsername(username);
                currentUser.setPassword(password);
                currentUser.setEmail(email);
                return currentUser;
            }
        },user.getUsername(),user.getPassword());

        return currentUser;
    }

    @Override
    public boolean regist(User user) {

        //创建数据源事务管理员、设置数据源
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        transactionManager.setDataSource(driverManagerDataSource);

        //创建事务模板、设置事务的管理员
//        TransactionTemplate transactionTemplate = new TransactionTemplate();
//        transactionTemplate.setTransactionManager(transactionManager);

        //通过Spring的IOC容器实例化工厂并自动注入属性值可以省去创建对象和设置参数的工作
//        jdbcTemplate.setDataSource(driverManagerDataSource);

        final String username = user.getUsername();
        final String password = user.getPassword();
        Integer result = transactionTemplate.execute(new TransactionCallback<Integer>() {

            @Override
            public Integer doInTransaction(TransactionStatus transactionStatus) {

                //数据库操作
                String sql = "insert into user values(?,?,?,?)";
                Object[] params = {null, username, password, null};
                int update = jdbcTemplate.update(sql, params);
                //int a = 3/0;
                return update;
            }
        });

        if(result!=0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean active() {
        return false;
    }
}
