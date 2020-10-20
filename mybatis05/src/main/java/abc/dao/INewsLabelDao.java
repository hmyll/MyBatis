package abc.dao;

import abc.beans.NewsLabel;
import abc.beans.NewsLabel2;

import java.util.List;

public interface INewsLabelDao {

    //查询某栏目及其所有的子栏目
    public NewsLabel selectNewsLabelById(int id);
    //查询某栏目的所有子栏目
    public List<NewsLabel> selectChildrenByParent(int pid);
    //查询某栏目及其所有的父栏目
    public NewsLabel2 selectNewsLabelById2(int id);
}
