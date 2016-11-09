package com.gmail.janderic.kuk.tij4.chapter21.wait;

import java.util.concurrent.TimeUnit;

public class Thread2 implements Runnable {

	private Thread1 t = null;
	
	Thread2(Thread1 t) {
		this.t = t;
		System.out.println("Thread2 constractor.");
	}
	
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				System.out.println("Thread2 5s后唤醒Thread1");
				TimeUnit.SECONDS.sleep(5);
				synchronized (t) {
					t.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
