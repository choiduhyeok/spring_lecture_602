package com.spring.service;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberService {
	
	MemberVO getMemberById(String id)throws SQLException;
}
