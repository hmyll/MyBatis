package com.abc.test;


import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import com.abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
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

    @Test
    public void test01(){
       Student student = new Student("张", 25, -1);
      // Student student = new Student(null,25,-1);
        //Student student = new Student("张",-1,-1);
        //Student student = new Student(null,-1,-1);
        List<Student> list = dao.selectStudentsByIf(student);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test02(){
        Student student = new Student("张", 25, -1);
        //Student student = new Student(null,25,-1);
        //Student student = new Student("张",-1,-1);
        //Student student = new Student(null,-1,-1);
        List<Student> list = dao.selectStudentsByWhere(student);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test03(){
        //Student student = new Student("张", 25, -1);
        //Student student = new Student(null,25,-1);
        Student student = new Student("张",-1,-1);
        //Student student = new Student(null,-1,-1);
        List<Student> list = dao.selectStudentsByChoose(student);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test04(){
        int[] idx = {10,20,30};
        List<Student> list = dao.selectStudentsByForeachArray(idx);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test05(){
        ArrayList<Integer> idx = new ArrayList<Integer>();
        idx.add(10);
        idx.add(20);
        idx.add(30);
        List<Student> list = dao.selectStudentsByForeachList(idx);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test06(){
        Student student1 = new Student();
        student1.setId(10);
        Student student2 = new Student();
        student2.setId(20);
        Student student3 = new Student();
        student3.setId(30);
        ArrayList<Student> idx = new ArrayList<Student>();
        idx.add(student1);
        idx.add(student2);
        idx.add(student3);
        List<Student> list = dao.selectStudentsByForeachList2(idx);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test07(){
        Student student1 = new Student();
        student1.setId(10);
        Student student2 = new Student();
        student2.setId(20);
        Student student3 = new Student();
        student3.setId(30);
        ArrayList<Student> idx = new ArrayList<Student>();
        idx.add(student1);
        idx.add(student2);
        idx.add(student3);
        List<Student> list = dao.selectStudentsByFragment(idx);
        for (Student stu:list){
            System.out.println(stu);
        }
    }
}
