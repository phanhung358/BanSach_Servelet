package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	hoadonbo hdbo = null;
	hoadondao hd = new hoadondao();
	public ArrayList<hoadonbean> gethoadon() throws Exception{
		return hd.gethoadon();
	}
	public int Them(long mahoadon, long makh, Date ngaymua, boolean damua) throws Exception{
		return hd.Them(mahoadon, makh, ngaymua, damua);
	}
	public int Xoa(String mahoadon) throws Exception{
		return hd.Xoa(mahoadon);
	}
	public long Max() throws Exception{
		long Max = 0;
		for(hoadonbean h:hdbo.gethoadon()) {
			if(h.getMahoadon() > Max)
				Max = h.getMahoadon();
		}
		return Max;
	}
}
