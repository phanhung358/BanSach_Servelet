package bean;

import java.util.Date;

public class sachbean {
	private String masach;
	private String tensach;
	private String tacgia;
	private long gia;
	private long soluong;
	private String anh;
	private long sotap;
	private Date ngaynhap;
	private String maloai;
	public sachbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sachbean(String masach, String tensach, String tacgia, long gia, long soluong, String anh, long sotap,
			Date ngaynhap, String maloai) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
		this.sotap = sotap;
		this.ngaynhap = ngaynhap;
		this.maloai = maloai;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public long getSotap() {
		return sotap;
	}
	public void setSotap(long sotap) {
		this.sotap = sotap;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	
}
