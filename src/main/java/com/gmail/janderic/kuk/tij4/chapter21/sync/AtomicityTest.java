package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{
	private int i = 0;
	public synchronized void increment() {
		i++;
		i++;
	}
	public synchronized int getI() {
		return i;
	}
	@Override
	public void run() {
		while (true) {
			increment();
		}
	}
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		AtomicityTest command = new AtomicityTest();
		e.execute(command);
		while (true) {
			int i2 = command.getI();
			if(i2 % 2 != 0) {
				System.out.println(i2);
				System.exit(0);
			}
		}
	}
	
}
