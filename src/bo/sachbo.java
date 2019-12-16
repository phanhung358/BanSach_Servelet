package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao s = new sachdao();
	public ArrayList<sachbean> getsach() throws Exception{
		return s.getsach();
	}
	public int Them(String masach, String tensach, String tacgia, long gia, long soluong, Date ngaynhap, String anh, long sotap, String maloai) throws Exception{
		return s.Them(masach, tensach, tacgia, gia, soluong, ngaynhap, anh, sotap, maloai);
	}
	public int Sua(String masach, String tensach, String tacgia, long gia, long soluong, Date ngaynhap, String anh, long sotap, String maloai) throws Exception{
		return s.Sua(masach, tensach, tacgia, gia, soluong, ngaynhap, anh, sotap, maloai);
	}
	public int Xoa(String masach) throws Exception{
		return s.Xoa(masach);
	}
	public sachbean TimMaSach(String masach) throws Exception{
		return s.TimMaSach(masach);
	}
}
