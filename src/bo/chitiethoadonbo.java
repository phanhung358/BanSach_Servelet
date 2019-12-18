package bo;

import java.util.ArrayList;

import bean.chitiethoadonbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ct = new chitiethoadondao();
	public ArrayList<chitiethoadonbean> getchitiet() throws Exception{
		return ct.getchitiet();
	}
	public int Them(long machitiethd, String masach, int soluongmua, long mahoadon) throws Exception{
		return ct.Them(machitiethd, masach, soluongmua, mahoadon);
	}
	public int Xoa(long mahoadon) throws Exception{
		return ct.Xoa(mahoadon);
	}
	public long Max() throws Exception{
		long Max = 0;
		for(chitiethoadonbean c:this.getchitiet()) {
			if(c.getMachitiethd() > Max)
				Max = c.getMachitiethd();
		}
		return Max;
	}
}
