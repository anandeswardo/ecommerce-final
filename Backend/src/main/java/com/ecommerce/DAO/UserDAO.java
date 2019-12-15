package com.ecommerce.DAO;

import java.util.List;


import com.ecommerce.model.UserDetail;

public interface UserDAO {
	

	public boolean registerUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String username);
	

}