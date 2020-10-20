package abc.beans;

//查询父栏目
//现在看做多方
public class NewsLabel2 {
    private Integer id;
    private String name;
    //关联属性，一方
    private NewsLabel2 parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewsLabel2 getParent() {
        return parent;
    }

    public void setParent(NewsLabel2 parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "NewsLabel2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
