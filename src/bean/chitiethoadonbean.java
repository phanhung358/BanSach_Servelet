package bean;

public class chitiethoadonbean {
	private long machitiethd;
	private String masach;
	private int soluongmua;
	private long mahoadon;
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadonbean(long machitiethd, String masach, int soluongmua, long mahoadon) {
		super();
		this.machitiethd = machitiethd;
		this.masach = masach;
		this.soluongmua = soluongmua;
		this.mahoadon = mahoadon;
	}
	public long getMachitiethd() {
		return machitiethd;
	}
	public void setMachitiethd(long machitiethd) {
		this.machitiethd = machitiethd;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
}
