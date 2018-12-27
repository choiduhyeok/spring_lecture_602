package com.spring.process;

import org.springframework.stereotype.Component;

@Component
public class PrintMorning extends PrintHello {

	@Override
	public void printHello() {
		System.out.println("Good morning!");
	}

	@Override		
	public void printHello(String hello) {
		System.out.println(hello+"\nHow do you do?");
	}
	
	
}
