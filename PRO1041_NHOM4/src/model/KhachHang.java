/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class KhachHang {
    private int idKhachHang;
    private String maKh, tenKhachHang, sdtKhachHang;
    private int trangthai;
    private  Date ngayTao,ngaySua;

    public KhachHang() {
    }

    public KhachHang(String maKh, String tenKhachHang, String sdtKhachHang, int trangthai) {
        this.maKh = maKh;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.trangthai = trangthai;
    }

    public KhachHang(String maKh, String tenKhachHang, String sdtKhachHang, int trangthai, Date ngayTao, Date ngaySua) {
        this.maKh = maKh;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.trangthai = trangthai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public KhachHang(int idKhachHang, String maKh, String tenKhachHang, String sdtKhachHang, int trangthai, Date ngayTao, Date ngaySua) {
        this.idKhachHang = idKhachHang;
        this.maKh = maKh;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.trangthai = trangthai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public KhachHang(int idKhachHang, String maKh, String tenKhachHang, String sdtKhachHang, Date ngayTao, Date ngaySua) {
        this.idKhachHang = idKhachHang;
        this.maKh = maKh;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }
    public String trangThai(){
        if(trangthai == 0){
            return "Không hoạt động";
        }else{
            return "Hoạt động";
        }
    }
    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    
    
    
}
 