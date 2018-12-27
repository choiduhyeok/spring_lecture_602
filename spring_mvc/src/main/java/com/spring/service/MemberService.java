package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MemberVO;

public interface MemberService {
	
	List<MemberVO> getMemberList()throws SQLException;
	MemberVO getMember(String id)throws SQLException;
	
	void joinMember(MemberVO member)throws SQLException;
}








