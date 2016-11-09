package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreeKingdoms implements Runnable {
	
	private String name;
	private Doing doing;
	
	ThreeKingdoms(String name, Doing doing) {
		this.name = name;
		this.doing = doing;
	}
	
	@Override
	public void run() {
		doing.doingPartStatic(name);
	}
	
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		Doing doing = new Doing();
		e.execute(new ThreeKingdoms("刘备", doing));
		e.execute(new ThreeKingdoms("关羽", doing));
		e.execute(new ThreeKingdoms("张飞", doing));
		e.shutdown();
	}
}
