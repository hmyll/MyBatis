package abc.beans;

public class Minister {
    private Integer mid;
    private String mname;

    //关联属性
    private Country country;

    public Minister() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return mname;
    }

    public void setName(String name) {
        this.mname = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Minister{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", country=" + country +
                '}';
    }
}
