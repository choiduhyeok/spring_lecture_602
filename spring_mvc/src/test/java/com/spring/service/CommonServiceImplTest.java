package com.spring.service;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.controller.LoginRequest;
import com.spring.exception.IdNotFoundException;
import com.spring.exception.InvalidPasswordException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
public class CommonServiceImplTest {

	@Autowired
	private CommonService commonService;

	@Test
	public void login_test() throws SQLException{
		LoginRequest logReq = new LoginRequest();
		logReq.setId("one");
		logReq.setPwd("11111");

		boolean result = true;

		try {
			commonService.login(logReq);
		} catch (IdNotFoundException | InvalidPasswordException e) {
			result = false;
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		Assert.assertEquals(true, result);
	}
}
