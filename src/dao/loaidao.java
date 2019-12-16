package dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	dungchung dc = new dungchung();
	public boolean ktMa(String maloai) throws Exception{
		String sql = "select * from loai where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean kq=rs.next();
		rs.close();
		return kq;
	}
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		//b1: Kết nối vào CSDL
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from loai order by maloai";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		while(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			loaibean loai = new loaibean(maloai, tenloai);
			ds.add(loai);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return ds;
	}
	
	public int Them(String maloai, String tenloaimoi) throws Exception{
		dc.KetNoi();
		if(ktMa(maloai)) return 0;
		String sql = "insert into loai values(?, ?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloaimoi);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public int Sua(String maloai, String tenloai) throws Exception{
		dc.KetNoi();
		if(!ktMa(maloai)) return 0;
		String sql = "update loai set tenloai=? where maloai=? ";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public boolean ktLoaiSach(String maloai) throws Exception{
		String sql = "select * from sach where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		boolean kq=rs.next();
		rs.close();
		return kq;
	}
	
	public int Xoa(String maloai) throws Exception{
		dc.KetNoi();
		if(ktLoaiSach(maloai)) return 0;
		String sql = "delete from loai where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq=cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public loaibean TimMaLoai(String maloai) throws Exception{
		loaibean l = null;
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from loai where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		if(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			String ml = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			l = new loaibean(ml, tenloai);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return l;
	}
}
