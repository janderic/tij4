package com.gmail.janderic.kuk.tij4.chapter21.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Practice8 implements Runnable {

	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("守护线程："+Thread.currentThread()+" "+this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService e = Executors.newCachedThreadPool(new DaemonFactory());
		for (int i = 0; i < 3; i++) {
			e.execute(new Practice8());
		}
		int second = 4;
		System.out.println("主线程"+second+"秒后结束");
		TimeUnit.SECONDS.sleep(second);
		System.out.println("所有线程结束。");
	}

}
