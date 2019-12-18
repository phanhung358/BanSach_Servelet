package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dungchung {
	public Connection cn;
	public void KetNoi() throws Exception{
		//b1: Xác định HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("Đã xác định HQTCSDL");
		//b2: Kết nối
		String url = "jdbc:sqlserver://PHANHUNGPC:1433;databaseName=QlSach;user=sa;password=123";
		cn = DriverManager.getConnection(url);
		System.out.print("Đã kết nối");
		
	}
}
