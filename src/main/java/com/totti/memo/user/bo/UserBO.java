package com.totti.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totti.memo.common.EncryptUtils;
import com.totti.memo.user.dao.UserDAO;
import com.totti.memo.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	public int addUser(String loginId, String password, String name, String email) {
		
		// 암호화
		String encPassword = EncryptUtils.md5(password);
		
		
		return userDAO.insertUser(loginId, encPassword, name, email);
	}
	
	
	public User getUser(String loginId, String password) {
		
		//String encPassword = EncryptUtils.md5(password);
		
		//return userDAO.selectUser(loginId, encPassword);
		return userDAO.selectUser(loginId, EncryptUtils.md5(password));
		
		
	}
	
	
	
}
