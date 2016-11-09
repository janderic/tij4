package com.gmail.janderic.kuk.tij4.chapter21.sleep;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Practice6 implements Runnable {
	
	@Override
	public void run() {
		long currentTimeMillis = System.currentTimeMillis();
		doTask();
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + "线程了 "+(System.currentTimeMillis()-currentTimeMillis)/1000+" 秒 执行完毕");
	}

	int second = new Random().nextInt(10);
	
	protected void doTask() {
		System.out.println(Thread.currentThread() + "线程即将睡眠 "+second+" 秒。");
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			e.execute(new Practice6());
		}
		e.shutdown();
	}
}
