package com.spring.main;

import com.spring.process.PrintHello;
import com.spring.process.PrintMessage;
import com.spring.process.PrintMorning;

public class PrintMain {

	public static void main(String[] args) {
		PrintMessage printMsg = new PrintMessage();
		
		PrintHello printHello = new PrintHello();
		
		//printMsg.setPrintHello(printHello);
		
		printMsg.printHello();
		
		printHello = new PrintMorning();
		
		//printMsg.setPrintHello(printHello);
		
		printMsg.printHello();

	}

}





