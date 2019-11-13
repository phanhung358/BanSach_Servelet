package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	
	public void Them(String masach, String tensach, String tacgia, long gia, String anh, Date ngaynhap, String maloai,
			long soluong) {
		int n=ds.size();
		for(int i=0;i<n;i++){
			if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.
					toLowerCase().trim())){
				ds.get(i).setSoluong(ds.get(i).getSoluong() + soluong);
				ds.get(i).setThanhtien();
				return;
			}
		}
		giohangbean gh = new giohangbean(masach, tensach, tacgia, gia, anh, ngaynhap, maloai, soluong);
		ds.add(gh);
	}
	
	public long Tong() {
		long s = 0;
		for(giohangbean gh: ds)
			s+= gh.getThanhtien();
		return s;
	}
	
}
