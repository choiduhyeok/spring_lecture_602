package com.spring.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session=session;
	}
	
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		 MemberVO member=
		(MemberVO)session.selectOne("Member.selectMemberById",id);
		return member;
	}
	
}
