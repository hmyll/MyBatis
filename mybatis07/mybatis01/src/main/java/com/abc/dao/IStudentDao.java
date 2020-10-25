package com.abc.dao;


import com.abc.beans.Student;

import java.util.List;

public interface IStudentDao {
    public void insertStudent(Student student);
    public void insertStudentCatchId(Student student);
    public void upDateStudent(Student student);
    public void delectById(int id);
    public List<Student> selectAllStudent();
    public Student selectStudentById(int id);
}
