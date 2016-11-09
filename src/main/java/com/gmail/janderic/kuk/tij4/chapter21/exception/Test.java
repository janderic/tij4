package com.gmail.janderic.kuk.tij4.chapter21.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool(new ExceptionFactory());
		//ExecutorService e = Executors.newCachedThreadPool();
		//Thread.setDefaultUncaughtExceptionHandler(new MyThreadException());
		for (int i = 0; i < 5; i++) {
			e.execute(new ExceptionThread());
		}
		e.shutdown();
	}
}
