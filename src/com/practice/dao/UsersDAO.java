package com.practice.dao;

import java.util.List;

import com.practice.vo.Users;

public interface UsersDAO {
	// Private String username;
	// Private String password;
	// Private String phone;
	// Private String email;
	// Private String address;
	// Private String sex;
	// Private String age;
	// Private String money;

	public void insert(Users user) throws Exception;
		
	public void insert(String username,String password,String email,String regtime) throws Exception;
	
	public void insert(String username,String password,String email,String tel,String address,String sex,int age,String regtime) throws Exception;
	
	public void update(Users user) throws Exception;
	
	public void updatePassword(String username,String password) throws Exception;
	
	public void updateEmail(String username,String email) throws Exception;
	
	public void updateAddress(String username,String address) throws Exception;
	
	public void updtae(String username,String password,String email,String tel,String address,String sex,int age,String regtime) throws Exception;
	
	public void delete(Users user) throws Exception;
	
	public void delete(String username) throws Exception;
	
	public Users selectByName(String username) throws Exception;
	
	public boolean selectByNamePassword(String username ,String password )throws Exception;
	
	public List<Users> selectAll() throws Exception;
	
	public List<Users> selectByLike(String cond) throws Exception;

}
