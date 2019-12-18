package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hd = new hoadondao();
	public ArrayList<hoadonbean> gethoadon() throws Exception{
		return hd.gethoadon();
	}
	public int Them(long mahoadon, long makh, Date ngaymua, boolean damua) throws Exception{
		return hd.Them(mahoadon, makh, ngaymua, damua);
	}
	public int Xoa(long mahoadon) throws Exception{
		return hd.Xoa(mahoadon);
	}
	public long Max() throws Exception{
		long Max = 0;
		for(hoadonbean h:this.gethoadon()) {
			if(h.getMahoadon() > Max)
				Max = h.getMahoadon();
		}
		return Max;
	}
	public int XacNhan(long mahoadon) throws Exception{
		return hd.XacNhan(mahoadon);
	}
}
