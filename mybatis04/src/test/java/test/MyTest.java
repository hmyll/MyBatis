package test;


import abc.beans.Husband;
import abc.beans.Student;
import abc.dao.IHusbandDao;
import abc.dao.IStudentDao;
import abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MyTest {


    private SqlSession sqlSession;
    private IHusbandDao dao;
    private IStudentDao dao1;

    @Before
    public void before() throws IOException {
        //遇到异常时要处理时，首先点击alt+enter键，选择异常处理方式
        sqlSession = MybatisUtil.getSqlSession();
        //生成dao接口实现类对象
        dao = sqlSession.getMapper(IHusbandDao.class);
        dao1 = sqlSession.getMapper(IStudentDao.class);
    }

    @After
    public void after(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Test
    public void test01(){
        Husband husband = dao.selectHusbandById(1);
        System.out.println(husband);
    }

    @Test
    public void test02(){
        Student student = dao1.selectStudentById(1);
        System.out.println(student);
    }
}
