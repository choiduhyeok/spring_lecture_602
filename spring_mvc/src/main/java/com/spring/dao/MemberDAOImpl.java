package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberVO;


public class MemberDAOImpl implements MemberDAO {	
	
	private SqlSession session;
	public void setSession(SqlSession session){
		this.session=session;
	}
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList=
				(List<MemberVO>)session.selectList("MemberMapper.selectMemberList",null);
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = (MemberVO)session.selectOne(
				"MemberMapper.selectMemberById",id);
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		session.update("MemberMapper.insertMember",member);

	}

}
