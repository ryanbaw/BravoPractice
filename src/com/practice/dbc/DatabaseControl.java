package com.practice.dbc;
/**
 * 链接数据库
 * @author Lyons
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseControl
{
	public static Connection getConn()
	{
		Connection conn = null;

		String user 	= "root";
		String passwd	= "justdoit";
		String url = "jdbc:mysql://127.0.0.1:3306/BRAVO?useUnicode=true&characterEncoding=utf8";

		try {
			Class.forName("com.mysql.jdbc.Driver"); //加载mysq驱动
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载错误");
			e.printStackTrace();//打印出错详细信息
		}

		try {
			conn = DriverManager.getConnection(url,user,passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	/*
	 * 关闭登录资源
	 */
	public static void allClose(PreparedStatement pstmt,ResultSet rs,Connection conn)
	{
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 关闭增、删、改资源。
	 */
	public static void close(PreparedStatement pstmt,Connection conn)
	{
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmtOrder, PreparedStatement pstmtCommodity, Connection conn)
	{
		try {
			if (pstmtOrder != null) {
				pstmtOrder.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (pstmtCommodity != null) {
				pstmtCommodity.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
