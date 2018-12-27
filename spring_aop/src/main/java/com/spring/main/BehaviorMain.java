package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.advice.양치하기;
import com.spring.behavior.행동;
import com.spring.behavior.행동하기;

public class BehaviorMain {

	public static void main(String[] args) {
		ApplicationContext ctx=
				new GenericXmlApplicationContext("classpath:application-context.xml");
		
		행동 behavior = (행동)ctx.getBean("행동");
		
		behavior.식사하기();		
		behavior.잠자기();
		behavior.운동하기();

	}

}
