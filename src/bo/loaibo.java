package bo;

import dao.loaidao;

import java.util.ArrayList;

import bean.loaibean;

public class loaibo {
	loaidao ls = new loaidao();
	public ArrayList<loaibean> getloai() throws Exception{
		return ls.getloai();
	}
	
	public int Them(String maloai, String tenloaimoi) throws Exception{
		return ls.Them(maloai, tenloaimoi);
	}
	
	public int Sua(String maloai, String tenloaimoi) throws Exception{
		return ls.Sua(maloai, tenloaimoi);
	}
	
	public loaibean TimMaLoai(String maloai) throws Exception{
		return ls.TimMaLoai(maloai);
	}
	
	public int Xoa(String maloai) throws Exception{
		return ls.Xoa(maloai);
	}
}
