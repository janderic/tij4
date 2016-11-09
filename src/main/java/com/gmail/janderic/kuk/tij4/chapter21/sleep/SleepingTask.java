package com.gmail.janderic.kuk.tij4.chapter21.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.gmail.janderic.kuk.tij4.chapter21.MyFirstThread;

public class SleepingTask extends MyFirstThread {
	@Override
	public void run() {
		while (maxNum-- > 0) {
			exec();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			e.execute(new SleepingTask());
		}
		e.shutdown();
	}

}
