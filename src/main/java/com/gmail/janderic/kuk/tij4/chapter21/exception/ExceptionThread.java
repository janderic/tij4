package com.gmail.janderic.kuk.tij4.chapter21.exception;


public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		System.out.println("RUN:::");
		
		throw new RuntimeException("手动抛出异常.");
	}

}
