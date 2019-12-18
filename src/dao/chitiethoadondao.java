package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadonbean;

public class chitiethoadondao {
	dungchung dc = new dungchung();
	public ArrayList<chitiethoadonbean> getchitiet() throws Exception{
		ArrayList<chitiethoadonbean> ds = new ArrayList<chitiethoadonbean>();
		//b1: Kết nối vào CSDL
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from ChiTietHoaDon";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		while(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			long machitiethd = rs.getLong("MaChiTietHD");
			String masach = rs.getString("MaSach");
			int soluongmua = rs.getInt("SoLuongMua");
			long mahoadon = rs.getLong("mahoadon");
			
			chitiethoadonbean ct = new chitiethoadonbean(machitiethd, masach, soluongmua, mahoadon);
			ds.add(ct);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return ds;
	}
	public boolean ktMa(long machitiethd) throws Exception{
		String sql = "select * from ChiTietHoaDon where MaChiTietHD=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, machitiethd);
		ResultSet rs = cmd.executeQuery();
		boolean kq=rs.next();
		rs.close();
		return kq;
	}
	public int Them(long machitiethd, String masach, int soluongmua, long mahoadon) throws Exception{
		dc.KetNoi();
		if(ktMa(mahoadon)) return 0;
		String sql = "insert into ChiTietHoaDon values(?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, machitiethd);
		cmd.setString(2, masach);
		cmd.setInt(3, soluongmua);
		cmd.setLong(4, mahoadon);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public int Xoa(long mahoadon) throws Exception{
		dc.KetNoi();
		String sql = "delete from ChiTietHoaDon where MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, mahoadon);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
}
