/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class NguoiDungServices {

    private List<NguoiDung> listNguoiDung;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;

    public List<NguoiDung> getListnv() {
        listNguoiDung = new ArrayList<>();
        sql = " select IdNguoiDung,ten,MaNV,TenDangNhap,MatKhau,ChucVu,TrangThai,Ngaytao,NgaySua from NguoiDung where TrangThai =1;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung nguoiDuong = new NguoiDung(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
                listNguoiDung.add(nguoiDuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    public List<NguoiDung> getListnv0() {
        listNguoiDung = new ArrayList<>();
        sql = " select IdNguoiDung,ten,MaNV,TenDangNhap,MatKhau,ChucVu,TrangThai,Ngaytao,NgaySua from NguoiDung where TrangThai =0;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung nguoiDuong = new NguoiDung(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getDate(9));
                listNguoiDung.add(nguoiDuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    public void insertNhanVien(NguoiDung nguoiDung) {
        sql = "insert into NguoiDung(Ten,MaNV,TenDangNhap,MatKhau,ChucVu,TrangThai) values(?,?,?,?,?,?);";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nguoiDung.getTen());
            ps.setString(2, nguoiDung.getMaNV());
            ps.setString(3, nguoiDung.getTenDN());
            ps.setString(4, nguoiDung.getMatKhau());
            ps.setString(5, nguoiDung.getChucVu());
            ps.setInt(6, nguoiDung.getTrangThai());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNhanVien(NguoiDung nguoiDung, int idNd) {
        sql = "  update NguoiDung set Ten =? , MaNV =?, TenDangNhap=?"
                + ", MatKhau =?, ChucVu = ? ,TrangThai =? , NgaySua = GETDATE() where IdNguoiDung=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nguoiDung.getTen());
            ps.setString(2, nguoiDung.getMaNV());
            ps.setString(3, nguoiDung.getTenDN());
            ps.setString(4, nguoiDung.getMatKhau());
            ps.setString(5, nguoiDung.getChucVu());
            ps.setInt(6, nguoiDung.getTrangThai());
            ps.setInt(7, idNd);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace( );
        }
    }
    

}
