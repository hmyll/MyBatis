package com.abc.test;


import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import com.abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void test01() {
        Student student = new Student("张三",20,98.5);
        dao.insertStudent(student);
        sqlSession.commit();
    }

    @Test
    public void test02() {
        Student student = new Student("王五", 25, 78);
        System.out.println("插入前："+student);

        dao.insertStudentCatchId(student);
        sqlSession.commit();
        System.out.println("插入后："+student);
    }

    @Test
    public void test03(){
        Student student = new Student("李明",20,8);
        student.setId(3);
        sqlSession.commit();
        dao.upDateStudent(student);
    }

    @Test
    public void test04(){
        dao.delectById(2);
        sqlSession.commit();
    }

    @Test
    public void test05(){
        List<Student> list = dao.selectAllStudent();
        for(Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test06(){
        Student student = dao.selectStudentById(10);
        System.out.print(student);
    }

    @Test
    public void test07(){
        Map<Object,Student> map = dao.selectAllStudentMap();
        System.out.println(map.size());
        Student student = map.get("王五");
        System.out.println(student);
    }

    @Test
    public void test08(){
        List<Student> list = dao.selectStudentsByName("王");
      //  List<Student> list = dao.selectStudentsByName("张%' or 1=1 or'");
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test09(){
        Student student = new Student("张",30,-1);
        List<Student> list = dao.selectStudentsByCondition(student);
        for (Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test10(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sname","张");
        map.put("sage",30);
        Student stu1 = new Student("张", 0, 0);
        Student stu2 = new Student(null, 30, 0);
        map.put("stu1",stu1);
        map.put("stu2",stu2);
        List<Student> list = dao.selectStudentsByCondition2(map);
        for (Student stu:list){
            System.out.println(stu);
        }
    }
}
