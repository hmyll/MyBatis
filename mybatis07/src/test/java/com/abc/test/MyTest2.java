package com.abc.test;

import com.abc.utils.MybatisUtil;
import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class MyTest2 {

    private IStudentDao dao;
/*
    证明：二级缓存是存在的
    查询时，先到一级缓存查看，如果没有再到二级缓存中查询，如果都没有，就到DB查询
    得到结果后，先把结果放到一级缓存和二级缓存中，然后再返回查询语句
*/
    @Test
    public void test01() throws IOException {

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IStudentDao.class);
        Student student = dao.selectStudentById(6);
        System.out.println("第一次查询："+student);

        //关闭一级缓存
        sqlSession.close();

        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        dao = sqlSession2.getMapper(IStudentDao.class);
        Student student2 = dao.selectStudentById(6);
        System.out.println("第二次查询："+student2);

        sqlSession2.close();

        SqlSession sqlSession3 = MybatisUtil.getSqlSession();
        dao = sqlSession3.getMapper(IStudentDao.class);
        Student student3 = dao.selectStudentById(6);
        System.out.println("第二次查询："+student3);
    }

    /*
        证明：执行增删改操作会刷新（清空）二级缓存
        1）刷新（清空）二级缓存执行了什么？
        二级底层也是一个map
        key：haspcode +studentId + sql语句
        value:查询结果
        刷新（清空）二级缓存的实质是将二级缓存中的value置为null，但是key保留
        2）什么情况下到DB执行查询？
        （1）map中找不到对应的key，肯定没有对应的value
        （2）map中找到了对象的key，倒是value为null
     */
    @Test
    public void test02() throws IOException {

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IStudentDao.class);
        Student student = dao.selectStudentById(6);
        System.out.println("第一次查询："+student);

        //关闭一级缓存
        sqlSession.close();

        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        dao = sqlSession2.getMapper(IStudentDao.class);

        //执行增删改操作
        dao.insertStudent(new Student());

        Student student2 = dao.selectStudentById(6);
        System.out.println("第二次查询："+student2);
    }

}
