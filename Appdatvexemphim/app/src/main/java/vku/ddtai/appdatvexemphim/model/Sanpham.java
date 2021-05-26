package vku.ddtai.appdatvexemphim.model;

import java.io.Serializable;

public class Sanpham implements Serializable {
    public int id;
    public String tensanpham;
    public String anh;
    public int soluongve;
    public long gia;
    public String daodien;
    public String dienvien;
    public String khoichieu;
    public String thoiluong;
    public String theloai;
    public String mota;

    public Sanpham(int id, String tensanpham, String anh, int soluongve, long gia, String daodien, String dienvien, String khoichieu, String thoiluong, String theloai, String mota) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.anh = anh;
        this.soluongve = soluongve;
        this.gia = gia;
        this.daodien = daodien;
        this.dienvien = dienvien;
        this.khoichieu = khoichieu;
        this.thoiluong = thoiluong;
        this.theloai = theloai;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSoluongve() {
        return soluongve;
    }

    public void setSoluongve(int soluongve) {
        this.soluongve = soluongve;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getDaodien() {
        return daodien;
    }

    public void setDaodien(String daodien) {
        this.daodien = daodien;
    }

    public String getDienvien() {
        return dienvien;
    }

    public void setDienvien(String dienvien) {
        this.dienvien = dienvien;
    }

    public String getKhoichieu() {
        return khoichieu;
    }

    public void setKhoichieu(String khoichieu) {
        this.khoichieu = khoichieu;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
