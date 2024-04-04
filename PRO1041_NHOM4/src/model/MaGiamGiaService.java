package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MaGiamGia;
import service.DBConnect;

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
				MaGiamGia maGiamGia = new MaGiamGia();
				maGiamGia.setIdMaGiamGia(rs.getInt("IDMaGiamGia"));
				maGiamGia.setMaGiamGia(rs.getString("MaGiamGia"));
				maGiamGia.setSoLuong(rs.getInt("SoLuong"));
				maGiamGia.setMenhGia(rs.getString("MenhGia"));
				maGiamGia.setNgayBatDau(rs.getDate("NgayBatDau"));
				maGiamGia.setNgayKetThuc(rs.getDate("NgayKetThuc"));
				maGiamGia.setTrangThai(rs.getInt("TrangThai"));
				maGiamGia.setNgayTao(rs.getDate("NgayTao"));
				maGiamGia.setNgaySua(rs.getDate("NgaySua"));
				listMGG.add(maGiamGia);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listMGG;
	}

	public int insertMaGG(MaGiamGia maGiamGia) {
		int check = -1;
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
            check = ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return check;
	}
	
	public int updateMaGG(Integer id, MaGiamGia maGiamGia) {
		int check = -1;
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
            check = ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return check;
	}
	
	public int deleteMaGG(Integer id) {
		int check = -1;
		sql = "Delete From MaGiamGia Where IDMaGiamGia = ?)";
		try {
			con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            check = ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return check;
	}
}
