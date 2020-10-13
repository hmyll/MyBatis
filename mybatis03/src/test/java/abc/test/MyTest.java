package abc.test;


import abc.beans.Country;
import abc.beans.Minister;
import abc.dao.ICountryDao;
import abc.dao.IMinisterDao;
import abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MyTest {


    private SqlSession sqlSession;
    private ICountryDao dao;
    private IMinisterDao dao1;

    @Before
    public void before() throws IOException {
        //遇到异常时要处理时，首先点击alt+enter键，选择异常处理方式
        sqlSession = MybatisUtil.getSqlSession();
        //生成dao接口实现类对象
        dao = sqlSession.getMapper(ICountryDao.class);
        dao1 = sqlSession.getMapper(IMinisterDao.class);
    }

    @After
    public void after(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Test//一对多查询
    public void test01(){
        Country country = dao.selectCountryById(1);
        System.out.println(country);
    }

    @Test//多对一查询
    public void test02(){
        Minister minister = dao1.selectMinisterById(1);
        System.out.println(minister);
    }
}
