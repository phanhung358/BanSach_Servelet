package bo;

import dao.loaidao;

import java.util.ArrayList;

import bean.loaibean;

public class loaibo {
	loaidao ls = new loaidao();
	public ArrayList<loaibean> getloai() throws Exception{
		return ls.getloai();
	}
}
