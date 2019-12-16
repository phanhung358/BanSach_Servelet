package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;

public class dangnhapdao {
	dungchung dc = new dungchung();
	public dangnhapbean getDangNhap(String ten, String pas) throws Exception{
		dangnhapbean dn = null;
		//b1: Kết nối vào CSDL
		dc.KetNoi();
		//b2: Lấy dữ liễu về
		String sql = "select * from KhachHang where tendn=? and pass=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, ten);
		cmd.setString(2, pas);
		ResultSet rs = cmd.executeQuery(); //Lấy dữ liệu về
		if(rs.next()) {//Duyệt qua tập dữ liễu để lưu vào mảng ds
			long makh= rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodt = rs.getString("sodt");
			String email = rs.getString("email");
			String tendn = rs.getString("tendn");
			String pass = rs.getString("pass");
			dn = new dangnhapbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		rs.close();
		//b3: Đóng kết nối
		dc.cn.close();
		return dn;
	}
}
