package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}
	
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList=memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member=memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public void joinMember(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
	}

}
