package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLocal implements Runnable {

	private final int no;
	
	TestThreadLocal(int i) {
		this.no = i;
	}
	
	private ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 1;
		}
	};
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			t.set(t.get()+1);
			System.out.println("#"+no+" "+t.get());
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			e.execute(new TestThreadLocal(i));
		}
		e.shutdown();
	}

}
