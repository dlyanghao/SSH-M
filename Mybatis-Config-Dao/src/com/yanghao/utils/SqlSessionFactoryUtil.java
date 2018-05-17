package com.yanghao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * SqlSessionFactory
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory factory;

    static {

        try {
            SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
            factory = ssfb.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession(){
        return factory.openSession();
    }
}
