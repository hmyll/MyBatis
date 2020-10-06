package com.abc.dao;


import com.abc.beans.Student;
import com.abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class StudentDaoimpl implements IStudentDao {
    SqlSession sqlSession;
    public void insertStudent(Student student) {
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.insert("insertStudent",student);
         //   System.out.print(student.getName());
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public void insertStudentCatchId(Student student) {
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.insert("insertStudentCatchId",student);
            //   System.out.print(student.getName());
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public void upDateStudent(Student student) {
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.update("upDateStudent",student);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public void delectById(int id) {
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.delete("delectById",id);
            //   System.out.print(student.getName());
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public List<Student> selectAllStudent() {
        List<Student> list = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            list=sqlSession.selectList("selectAllStudent");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return list;
    }

    public Student selectStudentById(int id) {
        Student student = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            student=sqlSession.selectOne("selectStudentById",id);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return student;
    }
}
