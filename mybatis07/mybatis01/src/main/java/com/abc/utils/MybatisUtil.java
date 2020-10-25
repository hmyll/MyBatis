package com.abc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory = null;
    //工具类的异常处理通常是将异常抛出给方法调用者
    public static SqlSession getSqlSession()throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //单例模式
        if(factory==null){
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return factory.openSession();

    }
}
