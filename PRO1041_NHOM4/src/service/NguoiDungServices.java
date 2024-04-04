/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.*;

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
        sql = " select IdNguoiDung,ten,MaNV,TenDangNhap,MatKhau,ChucVu,TrangThai,Ngaytao,NgaySua from NguoiDung ;";
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

    public List<NguoiDung> getListnvByTrangThai(int trangThai) {
        listNguoiDung = new ArrayList<>();
        sql = " select IdNguoiDung,ten,MaNV,TenDangNhap,MatKhau,ChucVu,TrangThai,Ngaytao,NgaySua from NguoiDung where trangThai =?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, trangThai);
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
            e.printStackTrace();
        }
    }

    public void exportExcelKhachHang(List<NguoiDung> list) {
        // tạo workBook
        try {
            FileInputStream fis = new FileInputStream("dataJeanStore.xlsx");
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheetAt(2);

            // tạo headRow 
            XSSFRow headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("Id nhân viên");
            headRow.createCell(1).setCellValue("Mã nhân viên");
            headRow.createCell(2).setCellValue("Tên nhân viên");
            headRow.createCell(3).setCellValue("Tên đăng nhập");
            headRow.createCell(4).setCellValue("Mật khẩu");
            headRow.createCell(5).setCellValue("Chức vụ");
            headRow.createCell(6).setCellValue("Trạng thái");
            headRow.createCell(7).setCellValue("Ngày tạo");
            headRow.createCell(8).setCellValue("Ngày sửa");

            // tạo data row
            int index = 1;
            for (NguoiDung nguoiDung : list) {
                XSSFRow row = sheet.createRow(index++);
                row.createCell(0).setCellValue(nguoiDung.getIdNguoiDung());
                row.createCell(1).setCellValue(nguoiDung.getMaNV());
                row.createCell(2).setCellValue(nguoiDung.getTen());
                row.createCell(3).setCellValue(nguoiDung.getTenDN());
                row.createCell(4).setCellValue(nguoiDung.getMatKhau());
                row.createCell(5).setCellValue(nguoiDung.getChucVu());
                row.createCell(6).setCellValue(nguoiDung.getTrangThai());
                row.createCell(7).setCellValue(nguoiDung.getNgayTao());
                row.createCell(8).setCellValue(nguoiDung.getNgaySua());

            }
            // ghi file excel
            try (FileOutputStream fos = new FileOutputStream("dataJeanStore.xlsx");) {
                workBook.write(fos);
            }
        } catch (Exception e) {
        }

    }
}
