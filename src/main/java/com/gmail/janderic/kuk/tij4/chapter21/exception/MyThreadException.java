package com.gmail.janderic.kuk.tij4.chapter21.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyThreadException implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("MyThreadException.抓住异常了！");
		//e.printStackTrace();
	}

}
