package com.abc.dao;


import com.abc.beans.Student;

import java.util.*;

public interface IStudentDao {
    public void insertStudent(Student student);
    public void insertStudentCatchId(Student student);
    public void upDateStudent(Student student);
    public void delectById(int id);
    public List<Student> selectAllStudent();
    public Student selectStudentById(int id);

    public  Map<Object,Student> selectAllStudentMap();

    //模糊查询
    public  List<Student> selectStudentsByName(String name);

    //复合条件查询-对象封装
    public List<Student> selectStudentsByCondition(Student student);

    //复合条件查询-map封装
    public List<Student> selectStudentsByCondition2(Map<String,Object>map);
}
