package com.practice.dbc;
/**
 * 链接数据库
 * @author Lyons
 */
import java.sql.*;

public class DatabaseControl
{
	private final String DBDRIVER = "com.mysql.jdbc.Driver" ;         
	private final String DBURL = "jdbc:mysql://127.0.0.1:3306/BRAVO?useUnicode=true&characterEncoding=utf-8" ;
	private final String DBUSER = "root" ;
	private final String DBPASSWORD = "justdoit" ;
	private Connection conn = null ;

	public DatabaseControl()
	{
		try
		{
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 取得数据库连接
	public Connection getConnection()
	{
		return this.conn;
	}

	// 关闭数据库连接
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
