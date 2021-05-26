package vku.ddtai.appdatvexemphim.model;

public class Taikhoan {
    private int id;
    private String tendn;
    private String matkhau;

    public Taikhoan(int id, String tendn, String matkhau) {
        this.id = id;
        this.tendn = tendn;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
