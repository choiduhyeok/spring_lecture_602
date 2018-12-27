package com.spring.exception;

public class IdNotFoundException extends Exception {
	
	public IdNotFoundException(){
		super("존재하지 않는 ID 입니다.");
	}
}
