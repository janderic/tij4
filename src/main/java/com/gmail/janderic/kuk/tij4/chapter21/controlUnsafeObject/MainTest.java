package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {

	/**
	 * 测试两种同步方式效率
	 * @param args
	 */
	public static void main(String[] args) {
		Manager1 m1 = new Manager1();
		Manager2 m2 = new Manager2();
		
		ExecutorService e = Executors.newCachedThreadPool();
		// 自增
		Thread1 t10 = new Thread1(m1);
		Thread1 t11 = new Thread1(m2);
		
		e.execute(t10);
		e.execute(t11);
		
		// 检查
		Thread2 t20 = new Thread2(m1);
		Thread2 t21 = new Thread2(m2);
		
		e.execute(t20);
		e.execute(t21);
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("m1:"+t10+",m2:"+t11);
		System.exit(0);
	}
	/*
	 * 运行结果可得出：后者采用同步块的检查次数要比前者（同步方法）多，证明对象加锁的次数要比前者少，在保证线程安全的同时，尽可能的更多的访问
	 * m1:UnsafeObjManager:x=1000711, y=1000711,i:1304788,m2:UnsafeObjManager:x=1042683, y=1042686,i:1457383
	 */

}
