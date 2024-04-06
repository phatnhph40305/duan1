package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MaGiamGia;

public class MaGiamGiaService {
	private List<MaGiamGia> listMGG;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;
    
    public MaGiamGiaService() {
		// TODO Auto-generated constructor stub
	}

	public List<MaGiamGia> getListMGG() {
		listMGG = new ArrayList<>();
		sql = "SELECT * FROM MaGiamGia";
		try {
			con = DBConnect.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MaGiamGia MGGS = new MaGiamGia();
				MGGS.setIdMaGiamGia(rs.getInt("IDMaGiamGia"));
				MGGS.setMaGiamGia(rs.getString("MaGiamGia"));
				MGGS.setSoLuong(rs.getInt("SoLuong"));
				MGGS.setMenhGia(rs.getString("MenhGia"));
				MGGS.setNgayBatDau(rs.getDate("NgayBatDau"));
				MGGS.setNgayKetThuc(rs.getDate("NgayKetThuc"));
				MGGS.setTrangThai(rs.getInt("TrangThai"));
				MGGS.setNgayTao(rs.getDate("NgayTao"));
				MGGS.setNgaySua(rs.getDate("NgaySua"));
				listMGG.add(MGGS);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listMGG;
	}

	public String insertMaGG(MaGiamGia maGiamGia) {
		
		sql = "Insert Into MaGiamGia Values(?,?,?,?,?,?, getDate(), null)";
		try {
			con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maGiamGia.getMaGiamGia());
            ps.setInt(2, maGiamGia.getSoLuong());
            ps.setString(3, maGiamGia.getMenhGia());
            ps.setDate(4, (Date) maGiamGia.getNgayBatDau());
            ps.setDate(5, (Date) maGiamGia.getNgayKetThuc());
            ps.setInt(6, maGiamGia.getTrangThai());
            ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "Add thành công";
	}
	
	public String updateMaGG(Integer id, MaGiamGia maGiamGia) {
	
		sql = "Update MaGiamGia Set MaGiamGia = ?, SoLuong = ?, MenhGia = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ?, NgaySua = getDate() Where IDMaGiamGia = ?)";
		try {
			con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maGiamGia.getMaGiamGia());
            ps.setInt(2, maGiamGia.getSoLuong());
            ps.setString(3, maGiamGia.getMenhGia());
            ps.setDate(4, (Date) maGiamGia.getNgayBatDau());
            ps.setDate(5, (Date) maGiamGia.getNgayKetThuc());
            ps.setInt(6, maGiamGia.getTrangThai());
            ps.setInt(7, id);
            ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "Update thành công";
	}
	
	public String deleteMaGG(Integer id) {
		
		sql = "Delete From MaGiamGia Where IDMaGiamGia = ?)";
		try {
			con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "Delete thành công";
	}

   public MaGiamGia details(int id){
       sql = "SELECT * FROM MaGiamGia Where IDMaGiamGia = ?";
       MaGiamGia MGGS = new MaGiamGia();
       try {
           con = DBConnect.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           rs = ps.executeQuery();
           while (rs.next()) {               
               
                MGGS.setIdMaGiamGia(rs.getInt("IDMaGiamGia"));
                MGGS.setMaGiamGia(rs.getString("MaGiamGia"));
                MGGS.setSoLuong(rs.getInt("SoLuong"));
                MGGS.setMenhGia(rs.getString("MenhGia"));
                MGGS.setNgayBatDau(rs.getDate("NgayBatDau"));
                MGGS.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                MGGS.setTrangThai(rs.getInt("TrangThai"));
                MGGS.setNgayTao(rs.getDate("NgayTao"));
                MGGS.setNgaySua(rs.getDate("NgaySua"));
                
           }
       } catch (Exception e) {
           throw new RuntimeException();
       }
       return MGGS;
   }
}
