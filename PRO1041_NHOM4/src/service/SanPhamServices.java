/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.ChiTietSanPham;
import model.SanPham;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Acer
 */
public class SanPhamServices {

    private List<SanPham> listSP;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;

    public SanPhamServices() {
    }

    public List<SanPham> getListSP() {
        listSP = new ArrayList<>();
        sql = "select IdSanPham, Ma,ten,TrangThai,NgayTao,NgaySua from SanPham;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> getListSP1() {
        listSP = new ArrayList<>();
        sql = "select IdSanPham, Ma,ten,TrangThai,NgayTao,NgaySua from SanPham where TrangThai = 1 ;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> getListSP2() {
        listSP = new ArrayList<>();
        sql = "select IdSanPham, Ma,ten,TrangThai,NgayTao,NgaySua from SanPham where TrangThai = 0 ;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> findSanPham(int trangThai, String search) {
        listSP = new ArrayList<>();
        sql = "  select IdSanPham, Ma,ten,TrangThai,NgayTao,NgaySua from SanPham where TrangThai =? and ten like ? ;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.setString(2, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> findAllSanPham(String search) {
        listSP = new ArrayList<>();
        sql = "  select IdSanPham, Ma,ten,TrangThai,NgayTao,NgaySua from SanPham where ten like ? ;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public int insertSanPham(SanPham sanPham) {
        int check = -1;
        sql = "insert into SanPham(Ma,Ten,TrangThai) values(?,?,?);";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sanPham.getMaSP());
            ps.setString(2, sanPham.getTenSp());
            ps.setInt(3, sanPham.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return check = 0;
        }
        return check;
    }

    public int updateSP(int idSp, SanPham sp) {
        int check = -1;
        sql = " update SanPham set ma = ?,Ten =?,TrangThai = ?, ngaysua = getDate() where IdSanPham =?;";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSp());
            ps.setInt(3, sp.getTrangThai());
            ps.setInt(4, idSp);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return check = 0;
        }
        return check;
    }

    public void exportSanPham(List<SanPham> list) {
        try {
            FileInputStream fis = new FileInputStream("dataJeanStore.xlsx");
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheetAt(1);

            XSSFRow headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("ID sản phẩm");
            headRow.createCell(1).setCellValue("Mã sản phẩm");
            headRow.createCell(2).setCellValue("Tên sản phẩm");
            headRow.createCell(3).setCellValue("Trạng thái sản phẩm");
            headRow.createCell(4).setCellValue("Ngày tạo sản phẩm");
            headRow.createCell(5).setCellValue("Ngày sửa sản phẩm");

            int index = 1;
            for (SanPham sanPham : list) {
                XSSFRow row = sheet.createRow(index++);
                row.createCell(0).setCellValue(sanPham.getIdSP());
                row.createCell(1).setCellValue(sanPham.getMaSP());
                row.createCell(2).setCellValue(sanPham.getTenSp());
                row.createCell(3).setCellValue(sanPham.getTrangThai());
                row.createCell(4).setCellValue(sanPham.getNgayTaoSp());
                row.createCell(5).setCellValue(sanPham.getNgaySuaSP());

                try (FileOutputStream outputStream = new FileOutputStream("dataJeanStore.xlsx")) {
                    workBook.write(outputStream);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}
