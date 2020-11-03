package abc.test;


import abc.beans.Country;
import abc.dao.ICountryDao;
import abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MyTest {


    private SqlSession sqlSession;
    private ICountryDao dao;

    @Before
    public void before() throws IOException {
        //遇到异常时要处理时，首先点击alt+enter键，选择异常处理方式
        sqlSession = MybatisUtil.getSqlSession();
        //生成dao接口实现类对象
        dao = sqlSession.getMapper(ICountryDao.class);
    }

    @After
    public void after(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Test//一对多查询--延迟加载
    public void test03(){
        //查询语句
        Country country = dao.selectCountryById(1);
        //访问主加载对象详情
        System.out.println("country.names="+country.getCname());
        //访问关联对象详情
        System.out.println("country.minister.size"+country.getMinisters().size());
    }
}
