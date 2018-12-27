package com.spring.process;

import org.springframework.stereotype.Component;

@Component
public class PrintHello {
	
	private String hello;
	
	public PrintHello(){}
	public PrintHello(String hello){
		this.hello=hello;
	}
	
	public void setHello(String hello){
		this.hello=hello;
	}
	
	public void printHello(){
		System.out.println("Hello Springframework!!!");
		
	}
	
	public void printHello(String hello){
		System.out.println(hello);
	}
}
