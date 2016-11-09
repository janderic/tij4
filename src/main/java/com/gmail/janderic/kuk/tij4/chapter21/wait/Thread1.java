package com.gmail.janderic.kuk.tij4.chapter21.wait;

import java.util.concurrent.TimeUnit;

public class Thread1 implements Runnable {

	public Thread1() {
		System.out.println("Thread1 constractor.");
	}
	
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			synchronized (this) {
				try {
					System.out.println("Thread1 2s后开启等待");
					TimeUnit.SECONDS.sleep(2);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread1重新被唤醒");
			}
		}
	}

}
