package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DualSynch implements Runnable {
	private Object o = new Object();
	private Object o2 = new Object();
	private Object o3 = new Object();
	
	public void f() {
		synchronized (o) {
			for (int i = 0; i < 5; i++) {
				System.out.println("f()");
				Thread.yield();
			}
		}
	}
	
	public void g() {
		synchronized (o) {
			for (int i = 0; i < 5; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	
	public void s() {
		synchronized (o) {
			for (int i = 0; i < 5; i++) {
				System.out.println("s()");
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			e.execute(new DualSynch());
		}
		e.shutdown();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			g();
			f();
			s();
		}
	}
}
