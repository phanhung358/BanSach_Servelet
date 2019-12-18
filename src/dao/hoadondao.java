package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;

public class hoadondao {
	dungchung dc = new dungchung();
	public ArrayList<hoadonbean> gethoadon() throws Exception{
		ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
		//b1: Kết nối vào CSDL
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from hoadon";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		while(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			long mahoadon = rs.getLong("MaHoaDon");
			long makh = rs.getLong("makh");
			Date ngaymua = rs.getDate("ngaymua");
			boolean damua = rs.getBoolean("damua");
			
			hoadonbean hd = new hoadonbean(mahoadon, makh, ngaymua, damua);
			ds.add(hd);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return ds;
	}
	public boolean ktMa(long mahoadon) throws Exception{
		String sql = "select * from hoadon where MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, mahoadon);
		ResultSet rs = cmd.executeQuery();
		boolean kq=rs.next();
		rs.close();
		return kq;
	}
	public int Them(long mahoadon, long makh, Date ngaymua, boolean damua) throws Exception{
		dc.KetNoi();
		if(ktMa(mahoadon)) return 0;
		java.sql.Date sqldate = new java.sql.Date(ngaymua.getTime());
		String sql = "insert into hoadon values(?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, mahoadon);
		cmd.setLong(2, makh);
		cmd.setDate(3, sqldate);
		cmd.setBoolean(4, damua);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public int Xoa(long mahoadon) throws Exception{
		dc.KetNoi();
		String sql = "delete from hoadon where MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, mahoadon);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public int XacNhan(long mahoadon) throws Exception{
		dc.KetNoi();
		if(!ktMa(mahoadon)) return 0;
		String sql = "update hoadon set damua=?  where mahoadon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setBoolean(1, true);
		cmd.setLong(2, mahoadon);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
}
