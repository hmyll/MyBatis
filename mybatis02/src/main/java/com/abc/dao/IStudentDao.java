package com.abc.dao;


import com.abc.beans.Student;

import java.util.List;

public interface IStudentDao {
    //使用if标签
    public List<Student> selectStudentsByIf(Student student);
    //使用where标签
    public List<Student> selectStudentsByWhere(Student student);
    //使用choose标签
    public List<Student> selectStudentsByChoose(Student student);
    //使用foreach标签
    public List<Student> selectStudentsByForeachArray(int[] idx);
    //使用foreach标签
    public List<Student> selectStudentsByForeachList(List<Integer> list);
    //使用foreach标签
    public List<Student> selectStudentsByForeachList2(List<Student> stu);
    //使用sql片段
    public List<Student> selectStudentsByFragment(List<Student> stu);
}
