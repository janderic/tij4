package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDemo implements Runnable {

	private int num = 100;
	
	private String str = new String();
	
	@Override
	public void run() {
		//synchronized (str) {
			while (num-->0) {
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + ":"+num);
			}
		//}
	}
	
	public static void main(String[] args) {
		/*ExecutorService e = Executors.newCachedThreadPool();
		e.execute(new SimpleDemo());
		e.execute(new SimpleDemo());
		e.execute(new SimpleDemo());
		e.execute(new SimpleDemo());
		e.shutdown();*/
		Thread t1 = new Thread(new SimpleDemo());
		Thread t2 = new Thread(new SimpleDemo());
		Thread t3 = new Thread(new SimpleDemo());
		Thread t4 = new Thread(new SimpleDemo());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
