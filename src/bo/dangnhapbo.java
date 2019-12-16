package bo;

import java.util.ArrayList;

import bean.dangnhapbean;
import dao.dangnhapdao;

public class dangnhapbo {
	dangnhapdao dn = new dangnhapdao();
	public dangnhapbean getDangNhap(String ten, String pas) throws Exception{
		return dn.getDangNhap(ten, pas);
	}
}
