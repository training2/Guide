package com.training2.guide.dao.orm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactory {

    private static final String mybatisResource = "com/training2/guide/dao/orm/mybatis/mybatis-config.xml";
    private static SqlSessionFactory sessionFactory = null;
    private static InputStream inputStream;
    private SqlSession session;

    public static SqlSession getSession() {
        if(sessionFactory == null) {
            try {
                inputStream = Resources.getResourceAsStream(mybatisResource);
                sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }

    public void close() {
        if(session != null) {
            session.close();
        }
    }
}
