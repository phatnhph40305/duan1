/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class QuanLyKhachHang {

    private List<KhachHang> listKhachHang;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = "";

    public List<KhachHang> getListKhachHang() {
        listKhachHang = new ArrayList<>();
        sql = "select MaKH,Ten,SDT,TrangThai,NgayTao,NgaySua,IdKhachHang from KhachHang";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getInt(7), rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public void insertKhachHang(KhachHang khachHang) {
        sql = "insert into KhachHang(MaKH,Ten,SDT,TrangThai) values(?,?,?,?);";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, khachHang.getMaKh());
            ps.setString(2, khachHang.getTenKhachHang());
            ps.setString(3, khachHang.getSdtKhachHang());
            ps.setInt(4, khachHang.getTrangthai());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<KhachHang> searchByName(String name) {
        listKhachHang = new ArrayList<>();
        sql = " select IdKhachHang,MaKH,Ten,sdt,TrangThai,NgayTao,NgaySua from KhachHang where ten like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,"%" + name + "%"  );
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
                listKhachHang.add(khachHang);
            }
            return listKhachHang;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateKH(KhachHang kh, int idKH) {
        sql = "update   KhachHang set MaKH =? , Ten = ? ,SDT =?,TrangThai=?, NgaySua = GETDATE() where IdKhachHang =?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKh());
            ps.setString(2, kh.getTenKhachHang());
            ps.setString(3, kh.getSdtKhachHang());
            ps.setInt(4, kh.getTrangthai());
            ps.setInt(5, idKH);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
