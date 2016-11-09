package com.gmail.janderic.kuk.tij4.chapter21.bean.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test implements Runnable {
	
	private static int no = 0;
	private final int id = no++;

	@Override
	public void run() {
			Bean bean = (Bean) SingletonBeanFactory.INSTANCE.getBean(Bean.class);
			System.out.println(id+":"+bean);
//			Bean2 bean2 = (Bean2) SingletonBeanFactory.INSTANCE.getBean(Bean2.class);
//			System.out.println(id+":"+bean2);
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 50; i++) {
			e.execute(new Test());
		}
		e.shutdown();
	}
}
