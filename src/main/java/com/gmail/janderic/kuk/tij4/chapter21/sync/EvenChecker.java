package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EvenChecker implements Runnable {

	private IntGenerator generator;

	private final int id;
	
	//private EvenChecker(){}
	
	public EvenChecker(IntGenerator generator, int initCount) {
		this.generator = generator;
		this.id = initCount;
	}
	
	@Override
	public void run() {
		while(!generator.isCanceled()) {
			int next = generator.next();
			if(next % 2 != 0) {// 检测到奇数
				System.out.println("#"+id+"存在奇数:"+next);
				generator.cancel();
			}
		}
	}

	public static void test(IntGenerator generator, int count) {
		System.out.println("任务查找到奇数前会一直执行。");
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			e.execute(new EvenChecker(generator, i));
		}
		e.shutdown();
	}
	
}
