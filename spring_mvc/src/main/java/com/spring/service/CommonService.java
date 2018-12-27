package com.spring.service;

import java.sql.SQLException;

import com.spring.controller.LoginRequest;
import com.spring.exception.IdNotFoundException;
import com.spring.exception.InvalidPasswordException;

public interface CommonService {
	
	void login(LoginRequest logReq)throws IdNotFoundException,
									 	  InvalidPasswordException,
									 	  SQLException;
}
