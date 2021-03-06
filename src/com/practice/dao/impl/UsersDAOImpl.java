package com.practice.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.practice.dao.UsersDAO;
import com.practice.dbc.DatabaseControl;
import com.practice.vo.Users;

public class UsersDAOImpl implements UsersDAO {

	public void delete(Users user) throws Exception {

		String sql = "DELETE FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			// 进行数据库更新操作
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			pstmt.close();
			dbc.close();
		}
	}

	public void delete(String username) throws Exception {

		String sql = "DELETE FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void insert(Users user) throws Exception {

		String sql="INSERT INTO user (username,password,phone,email,address,sex,age,money,regtime) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getSex());
			pstmt.setInt(7, user.getAge());
			pstmt.setDouble(8, user.getMoney());
			pstmt.setString(9, user.getRegtime());
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void insert(String username, String password, String phone,
			String regtime) throws Exception {
		String sql="INSERT INTO user (username,password,phone) VALUES (?,?,?) ";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void insert(String username, String password, String phone,
			String email, String address, String sex, int age, double money, String regtime)
			throws Exception {
		String sql="INSERT INTO user (username,password,phone,email,address,sex,age,money,regtime) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, sex);
			pstmt.setInt(7, age);
			pstmt.setDouble(8, money);
			pstmt.setString(9, regtime);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public List<Users> selectAll() throws Exception {
		List<Users> userlist = new ArrayList<Users>();
		String sql = "SELECT * FROM user";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			dbc.getConnection().setAutoCommit(true);
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				Users user=new Users();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setMoney(rs.getDouble(8));
				user.setRegtime(rs.getString(9));
				// 将查询出来的数据加入到List对象之中
				userlist.add(user);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return userlist;
	}

	public Users selectByName(String username) throws Exception {
		Users user = null;
		String sql = "SELECT * FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		ResultSet rs=null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			// 进行数据库查询操作
			rs= pstmt.executeQuery();
			if (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				user=new Users();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setMoney(rs.getDouble(8));
				user.setRegtime(rs.getString(9));
			}
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			rs.close();
			pstmt.close();
			dbc.close();
		}
		return user;
	}
	
	public boolean selectByNamePassword(String username, String password)
			throws Exception {

		String sql = "SELECT * FROM usershort WHERE username=? and password=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		boolean ret = false;
		ResultSet rs = null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置用户查询条件
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// 进行数据库查询操作
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ret = true;
			}
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			rs.close();
			pstmt.close();
			// 关闭数据库连接
			dbc.close();
		}
		System.out.println(ret);
		return ret;
	}
    
	
	public List<Users> selectByLike(String cond) throws Exception{
		List<Users> userlist = new ArrayList<Users>();
		String sql = "SELECT * FROM user WHERE username LIKE ? or address LIKE ?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置模糊查询条件
			pstmt.setString(1, "%" + cond + "%");
			pstmt.setString(2, "%" + cond + "%");
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				while(rs.next()) {
					// 查询出内容，之后将查询出的内容赋值给user对象
					Users user=new Users();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setPhone(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setAddress(rs.getString(5));
					user.setSex(rs.getString(6));
					user.setAge(rs.getInt(7));
					user.setMoney(rs.getDouble(8));
					user.setRegtime(rs.getString(9));
					// 将查询出来的数据加入到List对象之中
					userlist.add(user);
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

		return userlist;
	}

	public void update(Users user) throws Exception {
		String sql = "UPDATE user SET password=?,phone=?,email=?,address=?,sex=?,age=?,regtime=? WHERE username=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getPhone());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getSex());
			pstmt.setInt(6, user.getAge());
			pstmt.setString(7, user.getRegtime());
			pstmt.setString(8, user.getUsername());
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}

	public void updatePassword(String username, String password)
			throws Exception {

		String sql = "UPDATE user SET password=? WHERE username=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void updatePhone(String username, String phone)
			throws Exception {
		String sql = "UPDATE user SET phone=? WHERE username=? ";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, phone);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void updateEmail(String username, String email)
			throws Exception {
		String sql = "UPDATE user SET email=? WHERE username=? ";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}
	
	public void updateAddress(String username, String address) throws Exception {

		String sql = "UPDATE user SET address=? WHERE username=? ";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, address);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void updateMoney(String username, String money) throws Exception {

		String sql = "UPDATE user SET money=? WHERE username=? ";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, money);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void updtae(String username, String password, String phone,
			String email, String address, String sex, int age, String regtime)
			throws Exception {
		String sql = "UPDATE user SET password=?,phone=?,email=?,address=?,sex=?,age=?,regtime=? WHERE username=?";
		PreparedStatement pstmt = null;
		DatabaseControl dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DatabaseControl();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(3, phone);
			pstmt.setString(2, email);
			pstmt.setString(4, address);
			pstmt.setString(5, sex);
			pstmt.setInt(6, age);
			pstmt.setString(7, regtime);
			pstmt.setString(8, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}
}
