package com.spring.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("printMessage1")
public class PrintMessage {
	
	@Autowired(required=false)
	private PrintHello printHello;
	/*public void setPrintHello(PrintHello printHello){
		this.printHello=printHello;
	}*/
	
	public void printHello(){
		printHello.printHello();
	}
	
	public void printHello(String hello){
		printHello.printHello(hello);
	}
	
	public void printMessage(String sender, String message){
		System.out.println("보낸사람 : " + sender);
		System.out.println("message : " + message);
	}
	
}





