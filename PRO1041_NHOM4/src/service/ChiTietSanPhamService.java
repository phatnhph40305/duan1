package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ChiTietSanPham;
import model.SanPham;
import model.ThuocTinh;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ChiTietSanPhamService {

    public List loadDataTableCTSP() {
        List<ChiTietSanPham> litsctsp = new ArrayList<>();
        try {
            String sql = "select ChiTietSanPham.IdCTSP,SanPham.Ma,ChiTietSanPham.SoLuong,ChiTietSanPham.DonGia,MauSac.Ten,KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,ChiTietSanPham.TrangThai\n"
                    + "from ChiTietSanPham join SanPham on ChiTietSanPham.IdSanPham = SanPham.IdSanPham \n"
                    + "join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu join ThuongHieu on ThuongHieu.IdThuongHieu = ChiTietSanPham.IdThuongHieu \n"
                    + "join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
                litsctsp.add(ctsp);
            }
            return litsctsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboMaSP() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdSanPham,Ma from SanPham where trangthai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboThuongHieu() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdThuongHieu,TenThuongHieu from ThuongHieu where trangthai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboMauSac() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdMauSac,Ten from MauSac where trangthai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboXuatxu() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdXuatXu,ten from XuatXu where trangthai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboKichThuoc() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdKichThuoc,Ten from KichThuoc where trangthai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertChiTietSP(int soluong, double dongia, int mausac, int kichthuoc, int thuonghieu, int xuatxu, int trangthai, int sanpham) {
        try {
            String sql = "insert into ChiTietSanPham(SoLuong,DonGia,IdMauSac,IdKichThuoc,IdThuongHieu,IdXuatXu,TrangThai,IdSanPham) values(?,?,?,?,?,?,?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setDouble(2, dongia);
            ps.setInt(3, mausac);
            ps.setInt(4, kichthuoc);
            ps.setInt(5, thuonghieu);
            ps.setInt(6, xuatxu);
            ps.setInt(7, trangthai);
            ps.setInt(8, sanpham);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }

    public void deleteChiTietSP(int id) {
        try {
            String sql = "update ChiTietSanPham set TrangThai = 0\n"
                    + "where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }

    public void updateChiTietSP(int idctsp, int idsp, int soluong, double dongia, int idmausac, int idkichthuoc, int idthuonghieu, int idxuatxu, int trangthai) {
        try {
            String sql = "update ChiTietSanPham set IdSanPham = ?,SoLuong = ?,DonGia=?,IdMauSac=?,IdKichThuoc=?,IdThuongHieu=?,IdXuatXu=?,TrangThai=?,NgaySua= getdate()\n"
                    + "where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idsp);
            ps.setInt(2, soluong);
            ps.setDouble(3, dongia);
            ps.setInt(4, idmausac);
            ps.setInt(5, idkichthuoc);
            ps.setInt(6, idthuonghieu);
            ps.setInt(7, idxuatxu);
            ps.setInt(8, trangthai);
            ps.setInt(9, idctsp);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sửa thất bại");
        }
    }

    public List idSanPham(String ma) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdSanPham from SanPham where Ma = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List idMauSac(String ma) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdMauSac from MauSac where Ten = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List idKichThuoc(String ma) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdKichThuoc from KichThuoc where Ten = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List idXuatXu(String ma) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdXuatXu from XuatXu where Ten = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List idTHuongHieu(String ma) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdThuongHieu from ThuongHieu where TenThuongHieu = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List timkiemtheokhoanggia(double giamin, double giamax) {
        List<ChiTietSanPham> litsctsp = new ArrayList<>();
        try {
            String sql = "select ChiTietSanPham.IdCTSP,SanPham.Ma,ChiTietSanPham.SoLuong,ChiTietSanPham.DonGia,MauSac.Ten,KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,ChiTietSanPham.TrangThai\n"
                    + "                    from ChiTietSanPham join SanPham on ChiTietSanPham.IdSanPham = SanPham.IdSanPham\n"
                    + "                    join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu join ThuongHieu on ThuongHieu.IdThuongHieu = ChiTietSanPham.IdThuongHieu \n"
                    + "                    join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac where ChiTietSanPham.DonGia >= ? and ChiTietSanPham.DonGia <= ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, giamin);
            ps.setDouble(2, giamax);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
                litsctsp.add(ctsp);
            }
            return litsctsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void exportCTSanPham(List<ChiTietSanPham> list) {
        try {
            FileInputStream fis = new FileInputStream("dataJeanStore.xlsx");
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheetAt(3);

            XSSFRow headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("ID ctsp");
            headRow.createCell(1).setCellValue("Mã ctsp");
            headRow.createCell(2).setCellValue("Số lượng");
            headRow.createCell(3).setCellValue("Đơn giá");
            headRow.createCell(4).setCellValue("Màu sắc");
            headRow.createCell(5).setCellValue("kích thước");
            headRow.createCell(6).setCellValue("Thương hiệu");
            headRow.createCell(7).setCellValue("Xuất xứ");
            headRow.createCell(8).setCellValue("trạng thái");

            int index = 1;
            for (ChiTietSanPham ctsp : list) {
                XSSFRow row = sheet.createRow(index++);
                row.createCell(0).setCellValue(ctsp.getId());
                row.createCell(1).setCellValue(ctsp.getMaSP());
                row.createCell(2).setCellValue(ctsp.getSoluong());
                row.createCell(3).setCellValue(ctsp.getDongia());
                row.createCell(4).setCellValue(ctsp.getMauSac());
                row.createCell(5).setCellValue(ctsp.getKichThuoc());
                row.createCell(6).setCellValue(ctsp.getThuongHieu());
                row.createCell(7).setCellValue(ctsp.getXuatXu());
                row.createCell(8).setCellValue(ctsp.getTrangThai());

                try (FileOutputStream outputStream = new FileOutputStream("dataJeanStore.xlsx")) {
                    workBook.write(outputStream);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
