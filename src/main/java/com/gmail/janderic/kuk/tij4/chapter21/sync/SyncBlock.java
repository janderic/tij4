package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncBlock implements Runnable{

	NormalBean nb;
	
	public SyncBlock(NormalBean nb) {
		this.nb = nb;
	}
	
	@Override
	public void run() {
		while (true) {
			nb.setStr();
			int str = nb.getStr();
			if(str % 2 !=0) {
				System.out.println(Thread.currentThread()+","+str);
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		NormalBean nbb = new NormalBean();
		for (int i = 0; i < 200; i++) {
			
			e.execute(new Thread(new SyncBlock(nbb)));
		}
		e.shutdown();
	}
}
