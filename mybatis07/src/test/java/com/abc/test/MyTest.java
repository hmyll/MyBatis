package com.abc.test;


import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import com.abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MyTest {


    private IStudentDao dao;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //遇到异常时要处理时，首先点击alt+enter键，选择异常处理方式
        sqlSession = MybatisUtil.getSqlSession();
        //生成dao接口实现类对象
        dao = sqlSession.getMapper(IStudentDao.class);
    }

    @After
    public void after(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    //证明：一级缓存是存在的
    @Test
    public void test01() {
        Student student = dao.selectStudentById(6);
        System.out.println("第一次查询："+student);
        Student student2 = dao.selectStudentById(6);
        System.out.println("第二次查询："+student2);
    }

    /*
        证明：一级缓存中存放的不是对象本身，而是一个map
        一级缓存底层是一个map
        key：haspcode +studentId + sql语句
        value:查询结果
    */
    @Test
    public void test02() {
        Student student = dao.selectStudentById(6);
        System.out.println("第一次查询："+student);
        Student student2 = dao.selectStudentById2(6);
        System.out.println("第二次查询："+student2);
    }

    //执行增删改操作会刷新（清空）一级缓存
    @Test
    public void test03() {
        Student student = dao.selectStudentById(6);
        System.out.println("第一次查询："+student);

        //添加一个学生
        dao.insertStudent(new Student());

        Student student2 = dao.selectStudentById(6);
        System.out.println("第二次查询："+student2);
    }

}
