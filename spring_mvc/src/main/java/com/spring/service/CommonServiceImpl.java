package com.spring.service;

import java.sql.SQLException;

import com.spring.controller.LoginRequest;
import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.exception.IdNotFoundException;
import com.spring.exception.InvalidPasswordException;

public class CommonServiceImpl implements CommonService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}
	
	@Override
	public void login(LoginRequest logReq) throws IdNotFoundException, InvalidPasswordException, SQLException {
		MemberVO memberVO=memberDAO.selectMemberById(logReq.getId());
		
		if(memberVO!=null){
			if(!logReq.getPwd().equals(memberVO.getPwd())){
					
				throw new InvalidPasswordException();
			}
		}else{
			throw new IdNotFoundException();
		}
	}

}





