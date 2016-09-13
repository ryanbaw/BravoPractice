package com.practice.factory;

import com.practice.dao.UsersDAO;
import com.practice.dao.impl.UsersDAOImpl;

public class DAOFactory
{	
	public static UsersDAO getUserDAOInstance(){
		return new UsersDAOImpl();
	}
}
