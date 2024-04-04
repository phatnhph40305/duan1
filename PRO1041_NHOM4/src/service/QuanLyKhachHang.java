/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.*;

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
            ps.setString(1, "%" + name + "%");
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

    public void exportExcelKhachHang(List<KhachHang> list) {
        // tạo workBook
        try {
            FileInputStream fis = new FileInputStream("dataJeanStore.xlsx");
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheetAt(0);

            // tạo headRow 
            XSSFRow headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("Id khách hàng");
            headRow.createCell(1).setCellValue("Mã khách hàng");
            headRow.createCell(2).setCellValue("Tên khách hàng");
            headRow.createCell(3).setCellValue("SDT khách hàng");
            headRow.createCell(4).setCellValue("Trạng thái khách hàng");
            headRow.createCell(5).setCellValue("Ngày tạo khách hàng");
            headRow.createCell(6).setCellValue("Ngày sửa khách hàng");
            // tạo data row
            int index = 1;
            for (KhachHang khachHang : list) {
                XSSFRow row = sheet.createRow(index++);
                row.createCell(0).setCellValue(khachHang.getIdKhachHang());
                row.createCell(1).setCellValue(khachHang.getMaKh());
                row.createCell(2).setCellValue(khachHang.getTenKhachHang());
                row.createCell(3).setCellValue(khachHang.getSdtKhachHang());
                row.createCell(4).setCellValue(khachHang.getTrangthai());
                row.createCell(5).setCellValue(khachHang.getNgayTao());
                row.createCell(6).setCellValue(khachHang.getNgaySua());

            }
            // ghi file excel
            try (FileOutputStream fos = new FileOutputStream("dataJeanStore.xlsx");) {
                workBook.write(fos);
            }
        } catch (Exception e) {
        }

    }

}
