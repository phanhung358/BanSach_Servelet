package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;

public class sachdao {
	dungchung dc = new dungchung();
	public boolean ktMa(String masach) throws Exception{
		String sql = "select * from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery();
		boolean kq=rs.next();
		rs.close();
		return kq;
	}
	public ArrayList<sachbean> getsach() throws Exception{
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		//b1: Kết nối vào CSDL
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from sach";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		while(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			long soluong = rs.getLong("soluong");
			String sotap = rs.getString("sotap");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("NgayNhap");
			String maloai = rs.getString("maloai");
			sachbean sach = new sachbean(masach, tensach, tacgia, gia, soluong, anh, sotap, ngaynhap, maloai);
			ds.add(sach);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return ds;
	}
	public int Them(String masach, String tensach, String tacgia, long gia, long soluong, Date ngaynhap, String anh, String sotap, String maloai) throws Exception{
		dc.KetNoi();
		if(ktMa(masach)) return 0;
		java.sql.Date sqldate = new java.sql.Date(ngaynhap.getTime());
		String sql = "insert into sach values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setString(2, tensach);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, maloai);
		cmd.setString(6, sotap);
		cmd.setString(7, anh);
		cmd.setDate(8, sqldate);
		cmd.setString(9, tacgia);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public int Sua(String masach, String tensach, String tacgia, long gia, long soluong, Date ngaynhap, String anh, String sotap, String maloai) throws Exception{
		dc.KetNoi();
		if(!ktMa(masach)) return 0;
		java.sql.Date sqldate = new java.sql.Date(ngaynhap.getTime());
		String sql = "update sach set tensach=?, soluong=?, gia=?, maloai=?, sotap=?, anh=?, NgayNhap=?, tacgia=? where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tensach);
		cmd.setLong(2, soluong);
		cmd.setLong(3, gia);
		cmd.setString(4, maloai);
		cmd.setString(5, sotap);
		cmd.setString(6, anh);
		cmd.setDate(7, sqldate);
		cmd.setString(8, tacgia);
		cmd.setString(9, masach);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public int Xoa(String masach) throws Exception{
		dc.KetNoi();
		String sql = "delete from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public sachbean TimMaSach(String masach) throws Exception{
		sachbean s = null;
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		if(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			String masach1 = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			long soluong = rs.getLong("soluong");
			String sotap = rs.getString("sotap");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("NgayNhap");
			String maloai = rs.getString("maloai");
			s = new sachbean(masach1, tensach, tacgia, gia, soluong, anh, sotap, ngaynhap, maloai);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return s;
	}
}
