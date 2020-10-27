package com.abc.dao;


import com.abc.beans.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStudentDao {
/*
    1.注解首字母大写，因为注释是Java中类层级的成员之一，类层级的成员：类，接口，枚举，注解
    2.对于数组类型的属性赋值，使用（元素，元素。。。）
    3.若数组类型的属性只有一个元素值，那么{}可以省略
    4.在一个注解只使用一个属性，且为value属性，那么这个属性名可以省略
 */
//    @Insert(" insert into student (name,age,score) values(#{name},#{age},#{score})")
//    public void insertStudent(Student student);

//    @Insert(value = {" insert into student (name,age,score) values(#{name},#{age},#{score})"})
//    @SelectKey(statement = {"select last_insert_id()"},keyProperty = "id",before = false,resultType = int.class)
//    public void insertStudentCatchId(Student student);

//    @Update("update student set name=#{name },age=#{age},score=#{score} where  id=#{id}")
//    public void upDateStudent(Student student);

//    @Delete("delete from student where id=#{id}")
//    public void delectById(int id);

    @SelectProvider(type = MySQLProvider.class, method = "getSelectSql")
    public Student selectStudentById(int id);

    @SelectProvider(type = MySQLProvider.class, method = "getSelectSql2")
    public List<Student> selectAllStudent();

    @SelectProvider(type = MySQLProvider.class, method = "getSelectSql3")
    public List<Student> selectStudentsBycondition(Student student);

    @SelectProvider(type = MySQLProvider.class, method = "getSelectSql4")
    public List<Student> selectStudentsBycondition2(@Param("ccname") String cname,@Param("ccage") int cage,@Param("ccscore") double cscore) ;

    @InsertProvider(type = MySQLProvider.class,method = "getInsertSql")
    public void insertStudent(Student student);

    @InsertProvider(type = MySQLProvider.class,method = "getInsertSql")
    @SelectKey(statement = {"select last_insert_id()"},keyProperty = "id",before = false,resultType = int.class)
    public void insertStudentCatchId(Student student);

    @UpdateProvider(type = MySQLProvider.class,method = "getUpdateSql")
    public void upDateStudent(Student student);

    @UpdateProvider(type = MySQLProvider.class,method = "getUpdateSql2")
    public void upDateStudent2(Student student);

    @DeleteProvider(type = MySQLProvider.class,method = "getDeleteSql")
    public void delectById(int id);

    //数据表字段名和实体类的属性名不一致的解决方案
    //1.给不一致的字段名起别名，让别名和属性名一致
    //2.使用resultMap，建立字段名和属性名一一对应关系
    public Student selectStudentById2(int id);
    public Student selectStudentById3(int id);

}
