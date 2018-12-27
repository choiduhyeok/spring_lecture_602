package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.LoginDataVO;

public class LoginDataDAOImpl implements LoginDataDAO {
	
	private SqlSession session;
	public void setSqlSession(SqlSession session){
		this.session=session;
	}
	
	@Override
	public List<LoginDataVO> selectLoginData() throws SQLException {
		List<LoginDataVO> logList=session.selectList("Log.selectAllLog",null);
		return logList;
	}

	@Override
	public void insertLoginData(LoginDataVO log) throws SQLException {
		session.update("Log.insertLog",log);
	}

	@Override
	public void deleteLoginData() throws SQLException {
		session.update("Log.deleteAll",null);
	}

}
