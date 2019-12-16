package bo;

import java.util.ArrayList;

import bean.chitiethoadonbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ct = new chitiethoadondao();
	public ArrayList<chitiethoadonbean> gethoadon() throws Exception{
		return ct.gethoadon();
	}
	public int Them(long machitiethd, String masach, int soluongmua, long mahoadon) throws Exception{
		return ct.Them(machitiethd, masach, soluongmua, mahoadon);
	}
	public int Xoa(String mahoadon) throws Exception{
		return ct.Xoa(mahoadon);
	}
	public long Max() throws Exception{
		return ct.Max();
	}
}
