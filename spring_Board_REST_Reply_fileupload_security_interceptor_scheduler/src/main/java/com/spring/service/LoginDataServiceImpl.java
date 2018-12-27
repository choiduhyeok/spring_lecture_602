package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.LoginDataDAO;
import com.spring.dto.LoginDataVO;

public class LoginDataServiceImpl implements LoginDataService {
	
	private LoginDataDAO logDao;
	public void setLogDao(LoginDataDAO logDao){
		this.logDao=logDao;
	}
	
	
	@Override
	public List<LoginDataVO> getLoginData() throws SQLException {		
		return logDao.selectLoginData();
	}

	@Override
	public void insertLog(List<LoginDataVO> logList) throws SQLException {
		logDao.deleteLoginData();
		for(LoginDataVO log:logList){
			logDao.insertLoginData(log);
		}
	}

}








