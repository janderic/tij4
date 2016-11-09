package com.gmail.janderic.kuk.tij4.chapter21.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMap implements Runnable {

	private Bean bean;
	
	public TestMap(Bean bean) {
		this.bean = bean;
	}
	
	@Override
	public void run() {
		while (true) {
			bean.add("joker");
			bean.sysout();
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(new TestMap(new Bean()));
		e.execute(new TestMap(new Bean()));
		e.execute(new TestMap(new Bean()));
		e.execute(new TestMap(new Bean()));
		e.execute(new TestMap(new Bean()));
		e.shutdown();
	}
}
