package com.gmail.janderic.kuk.tij4.chapter21.garden;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Count {
	private static int num = 0;

	public volatile boolean isCancel = false;
	
	public void cancel() {
		isCancel = true;
	}
	
	public synchronized int getNum() {
		return num;
	}

	public synchronized void increment() {
		//synchronized (this) {
			num++;
			//Thread.yield();
			//num++;
	//	}
	}

	public synchronized void subsub() {
		num--;
	}
	
	public static void main(String[] args) {
		System.out.println("程序在没有检查到奇数前不会停止：");
		ExecutorService e = Executors.newCachedThreadPool();
		final Count c = new Count();
		for (int i = 0; i < 5; i++) {
			e.execute(new Thread1(c, i));
		}
		try {
			if(!e.awaitTermination(10, TimeUnit.SECONDS))
				e.shutdown();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
