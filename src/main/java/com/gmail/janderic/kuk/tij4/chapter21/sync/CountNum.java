package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountNum implements Runnable{
	
	private volatile int num = 0;
	private int no = 0;
	
	public void numAdd() {
		num = no+1;
	}
	
	public CountNum(int i) {
		no = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		numAdd();
		System.out.println("#"+no+":"+num);
	}
	
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			e.execute(new CountNum(i));
		}
		e.shutdown();
	}

}
