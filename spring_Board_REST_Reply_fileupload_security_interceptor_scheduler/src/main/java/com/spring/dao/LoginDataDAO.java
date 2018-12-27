package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.LoginDataVO;

public interface LoginDataDAO {
	
	List<LoginDataVO> selectLoginData()throws SQLException;
	void insertLoginData(LoginDataVO log)throws SQLException;
	void deleteLoginData()throws SQLException;
}
