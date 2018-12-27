package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.process.PrintMessage;

public class SpringContextMain {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:application-context.xml");
		
		PrintMessage printMsg1 = (PrintMessage)ctx.getBean("printMessage1");
		/*PrintMessage printMsg2 = (PrintMessage)ctx.getBean("printMessage2");*/
		
		printMsg1.printHello();
		/*printMsg2.printHello();*/
		
		

	}

}
