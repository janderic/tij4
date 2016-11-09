package com.gmail.janderic.kuk.tij4.chapter21.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		Thread1 thread1 = new Thread1();
		e.execute(thread1);
		e.execute(new Thread2(thread1));
		e.shutdown();
	}
}
