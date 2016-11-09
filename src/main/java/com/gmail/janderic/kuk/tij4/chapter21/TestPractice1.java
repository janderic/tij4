package com.gmail.janderic.kuk.tij4.chapter21;

public class TestPractice1 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new Practice1());
			thread.setName("Thread #"+i);
			thread.start();
		}
	}

}
