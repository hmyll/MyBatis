package com.abc.test;


import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import com.abc.dao.StudentDaoimpl;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        Student student = new Student("张三",20,98.5);
        IStudentDao studentDao = new StudentDaoimpl();
        studentDao.insertStudent(student);
    }

    @Test
    public void test02() {
        Student student = new Student("王五", 25, 78);
        System.out.println("插入前："+student);

        IStudentDao dao = new StudentDaoimpl();
        dao.insertStudentCatchId(student);
        System.out.println("插入后："+student);
    }

    @Test
    public void test03(){
        Student student = new Student("李明",20,8);
        student.setId(3);
        IStudentDao dao = new StudentDaoimpl();
        dao.upDateStudent(student);
    }

    @Test
    public void test04(){
        IStudentDao dao = new StudentDaoimpl();
        dao.delectById(4);
    }

    @Test
    public void test05(){
        IStudentDao dao = new StudentDaoimpl();
        List<Student> list = dao.selectAllStudent();
        for(Student stu:list){
            System.out.println(stu);
        }
    }

    @Test
    public void test06(){
        IStudentDao dao = new StudentDaoimpl();
        Student student = dao.selectStudentById(10);
        System.out.print(student);
    }
}
