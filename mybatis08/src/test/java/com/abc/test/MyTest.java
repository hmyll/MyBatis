package com.abc.test;


import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import com.abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

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

    //注解开发及其注解动态SQL
    @Test
    public void test01(){
        Student student = new Student("张飞", 25, 90);
        dao.insertStudent(student);
        sqlSession.commit();
    }

    @Test
    public void test02(){
        Student student = new Student("Tom", 20, 70);
        System.out.println("添加记录之前："+student);
        dao.insertStudentCatchId(student);
        sqlSession.commit();
        System.out.println("添加记录之后："+student);
    }

    @Test
    public void test03(){
        Student student = new Student("援朝", 23, 90);
        student.setId(8);
        dao.upDateStudent(student);
        sqlSession.commit();
    }

    @Test
    public void test04(){
        dao.delectById(7);
        sqlSession.commit();
    }

    @Test
    public void test05(){
        Student student = dao.selectStudentById(10);
        System.out.println(student);
    }

    @Test
    public void test06(){
        List<Student> students = dao.selectAllStudent();
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void test07(){
        Student student = new Student("张", 20, 100);
        List<Student> students = dao.selectStudentsBycondition(student);
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void test08(){
        Student student = new Student("张", 20, 100);
        List<Student> students = dao.selectStudentsBycondition2("张", 20, 100);
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void test09(){
        Student student = new Student("援朝", 23, 90);
        student.setId(8);
        dao.upDateStudent2(student);
        sqlSession.commit();
    }

    @Test
    public void test10(){//数据表字段名和实体类的属性名不一致的解决方案
        Student student = dao.selectStudentById2(9);
        System.out.println(student);
    }
}
