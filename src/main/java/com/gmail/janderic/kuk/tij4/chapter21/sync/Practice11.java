package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice11 implements Runnable{
	
	private int no = 0;
	
	private Practice11Sub sub;
	
	private boolean isCancel = false;
	
	public Practice11(int no, Practice11Sub sub) {
		this.no = no;
		this.sub = sub;
	}

	@Override
	public void run() {
		while (!isCancel) {
			sub.counterAdd();
			int i = sub.getCounter1();
			if(i % 2 != 0) {
				isCancel = true;
				System.out.println("#"+no+"发现奇数:"+i);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("找到任意奇数之前线程会一直执行");
		ExecutorService e = Executors.newCachedThreadPool();
		Practice11Sub s = new Practice11Sub();// 一份实例
		for (int i = 0; i < 5; i++) {
			e.execute(new Practice11(i, s));
		}
		e.shutdown();
	}

}
