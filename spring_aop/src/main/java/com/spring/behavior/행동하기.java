package com.spring.behavior;

import com.spring.advice.양치하기;

public class 행동하기 implements 행동 {
	
	
	@Override
	public void 잠자기() {
		System.out.println("쿨쿨~~~잠을 잡니다.");

	}

	@Override
	public void 식사하기() {
		System.out.println("우적우적..꿀꺽...밥을 먹습니다.");
	}

	@Override
	public void 운동하기() {
		System.out.println("다 같이 돌자..동네 한 바퀴");

	}

}
