package vo;

public class Bj {
    private Integer id;

    private String bjname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBjname() {
        return bjname;
    }

    public void setBjname(String bjname) {
        this.bjname = bjname == null ? null : bjname.trim();
    }
}