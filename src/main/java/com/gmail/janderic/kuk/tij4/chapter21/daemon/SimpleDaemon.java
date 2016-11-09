package com.gmail.janderic.kuk.tij4.chapter21.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread() + " "+ this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new SimpleDaemon());
			t.setDaemon(true);
			t.start();
		}
		System.out.println("main print sth.");
		TimeUnit.SECONDS.sleep(10);
	}
}
