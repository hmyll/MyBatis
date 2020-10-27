package com.abc.dao;

import com.abc.beans.Student;
import org.apache.ibatis.jdbc.SQL;

/*
    自定义类，不同方法提供不同SQL语句，给注释开发使用
 */
public class MySQLProvider {

    public String getSelectSql(){
        return "select id,name,age,score from student where id = #{xxx}";
    }

    public String getSelectSql2(){
        return "select id,name,age,score from student";
    }

    public String getSelectSql3(Student student){
        StringBuffer sql = new StringBuffer();
        sql.append("select id,name,age,score from student where 1=1");
        if(student.getName() != null && ! student.getName().equals("")){
            sql.append(" and name like '%' #{name} '%'");
        }
        if(student.getAge()>0){
            sql.append(" and age > #{age}");
        }
        if(student.getScore() > 0){
            sql.append(" and score < #{score}");
        }
        return sql.toString();
    }

    public String getSelectSql4(){
        return "select id,name,age,score from student where name like '%' #{ccname} '%' and age > #{ccage} and score < #{ccscore}";
    }

    public String getInsertSql(){
        return " insert into student (name,age,score) values(#{name},#{age},#{score})";
    }

    public String getUpdateSql(Student student){
        StringBuffer sql = new StringBuffer();
        sql.append("update student set id=#{id}");
        if(student.getName() != null && ! student.getName().equals("")){
            sql.append(",name=#{name}");
        }
        if(student.getAge()>0){
            sql.append(",age=#{age}");
        }
        if(student.getScore() > 0){
            sql.append(",score=#{score}");
        }
        sql.append(" where id = #{id}");
        return sql.toString();
    }

    public String getDeleteSql(){
        return "delete from student where id=#{xxx}";
    }

    public String getUpdateSql2(final Student student){
        //new SQL(){}表示创建一个SQL类的子类对象，但是这个子类没有命名，所有这种写法被叫匿名内部类的写
        return new SQL(){
            //在类中{}称为实例代码块
            //当当前类无参构造器被调用时，会执行{}代码块
            {
                this.UPDATE("student");
                this.SET("id=#{id}");
                if(student.getName() != null && ! student.getName().equals("")){
                    this.SET("name=#{name}");
                }
                if(student.getAge()>0){
                    this.SET("age=#{age}");
                }
                if(student.getScore() > 0){
                    this.SET("score=#{score}");
                }
                this.WHERE("id=#{id}");
            }
        }.toString();
    }
}
