package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class MaGiamGia {
	private int idMaGiamGia;
	private String maGiamGia;
	private int soLuong;
	private String menhGia;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private int trangThai;
	private Date ngayTao;
	private Date ngaySua;
	
	public MaGiamGia() {
		
	}

	public MaGiamGia(int idMaGiamGia, String maGiamGia, int soLuong, String menhGia, Date ngayBatDau, Date ngayKetThuc,
			int trangThai, Date ngayTao, Date ngaySua) {
		this.idMaGiamGia = idMaGiamGia;
		this.maGiamGia = maGiamGia;
		this.soLuong = soLuong;
		this.menhGia = menhGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
		this.ngaySua = ngaySua;
	}

    public MaGiamGia(String maGiamGia, int soLuong, String menhGia, Date ngayBatDau, Date ngayKetThuc, int trangThai, Date ngayTao, Date ngaySua) {
        this.maGiamGia = maGiamGia;
        this.soLuong = soLuong;
        this.menhGia = menhGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }
        
        

	public int getIdMaGiamGia() {
		return idMaGiamGia;
	}

	public void setIdMaGiamGia(int idMaGiamGia) {
		this.idMaGiamGia = idMaGiamGia;
	}

	public String getMaGiamGia() {
		return maGiamGia;
	}

	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMenhGia() {
		return menhGia;
	}

	public void setMenhGia(String menhGia) {
		this.menhGia = menhGia;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
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

	@Override
	public int hashCode() {
		return Objects.hash(idMaGiamGia, maGiamGia, menhGia, ngayBatDau, ngayKetThuc, ngaySua, ngayTao, soLuong,
				trangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaGiamGia other = (MaGiamGia) obj;
		return idMaGiamGia == other.idMaGiamGia && Objects.equals(maGiamGia, other.maGiamGia)
				&& Objects.equals(menhGia, other.menhGia) && Objects.equals(ngayBatDau, other.ngayBatDau)
				&& Objects.equals(ngayKetThuc, other.ngayKetThuc) && Objects.equals(ngaySua, other.ngaySua)
				&& Objects.equals(ngayTao, other.ngayTao) && soLuong == other.soLuong && trangThai == other.trangThai;
	}

    public ArrayList<MaGiamGia> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	

}

