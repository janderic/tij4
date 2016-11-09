package com.gmail.janderic.kuk.tij4.chapter21.exception;

import java.util.concurrent.ThreadFactory;

public class ExceptionFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyThreadException());
		return t;
	}

}
