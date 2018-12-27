package com.spring.dao;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	//id에 의한 member
	MemberVO selectMemberById(String id)throws SQLException;
			
}
