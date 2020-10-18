package abc.beans;

public class Wife {
    private Integer wid;
    private String wname;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                '}';
    }
}
