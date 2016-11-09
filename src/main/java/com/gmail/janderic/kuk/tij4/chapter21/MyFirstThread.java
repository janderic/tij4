package com.gmail.janderic.kuk.tij4.chapter21;

public class MyFirstThread implements Runnable{

	private static int no = 0;
	private final int ss = no++;
	
	protected int maxNum = 10;// default max
	
	public MyFirstThread() {
		
	}
	
	protected void exec() {
		System.out.println(ss+"#{"+maxNum+"} ");
	}
	
	@Override
	public void run() {
		while (maxNum-- > 0) {
			exec();
			Thread.yield();
		}
	}

}
