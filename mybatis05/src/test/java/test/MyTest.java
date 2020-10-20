package test;

import abc.beans.NewsLabel;
import abc.beans.NewsLabel2;
import abc.dao.INewsLabelDao;
import abc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MyTest {


    private SqlSession sqlSession;
    private INewsLabelDao dao;

    @Before
    public void before() throws IOException {
        //遇到异常时要处理时，首先点击alt+enter键，选择异常处理方式
        sqlSession = MybatisUtil.getSqlSession();
        //生成dao接口实现类对象
        dao = sqlSession.getMapper(INewsLabelDao.class);
        dao = sqlSession.getMapper(INewsLabelDao.class);
    }

    @After
    public void after(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    //查询某栏目及其所有的子栏目（下面一级子栏目）
    @Test
    public void test01(){
        NewsLabel newsLabel = dao.selectNewsLabelById(2);
        System.out.println(newsLabel);
    }

    //查询某栏目的所有子栏目
    @Test
    public void test02(){
        List<NewsLabel> list = dao.selectChildrenByParent(2);
        for (NewsLabel n1:list){
            System.out.println(n1);
        }
    }

    //查询某栏目及其所有的父栏目
    @Test
    public void test03(){
        NewsLabel2 newsLabel2 =  dao.selectNewsLabelById2(9);
        System.out.println(newsLabel2);
    }

}
