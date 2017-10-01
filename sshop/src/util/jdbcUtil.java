package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtil {
//url driver user password
	private static String url="jdbc:mysql://127.0.0.1:3306/shop?useUnicode=true&characterEncoding=utf8";
	private static String driver="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String password="root";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//链接
	public static Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,user,password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//关闭
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
