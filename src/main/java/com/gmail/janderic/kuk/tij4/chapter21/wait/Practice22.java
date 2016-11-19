package com.gmail.janderic.kuk.tij4.chapter21.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Types Practice22
 * @Description 一个忙等待的例子，后续会有这个例子的wait\notify版本
 * @author juchen
 * @date 2016年11月19日 上午11:42:01
 */
public class Practice22 {
    
    static volatile boolean GLOBAL_FLAG = false;
    
    static class T1 implements Runnable {
	private int SLEEP_TIME = 5;
	@Override
	public void run() {
	    while(true) {// 一直循环设置
		System.out.println("T1每"+SLEEP_TIME+"s将GLOBAL_FLAG设置成true...");
		try {
		    TimeUnit.SECONDS.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("设置GLOBAL_FLAG = true");
		GLOBAL_FLAG = true;
	    }
	}
    }
    
    static class T2 implements Runnable {
	@Override
	public void run() {
	    while(true) {// 一直循环检测
		while (GLOBAL_FLAG == true) {
		    System.out.println("T2发现GLOBAL_FLAG == true， 再将其设置成false");
		    GLOBAL_FLAG = false;
		}
	    }
	}
    }
    
    public static void main(String[] args) {
	ExecutorService pool = Executors.newCachedThreadPool();
	pool.execute(new T1());
	pool.execute(new T2());
	pool.shutdown();
    }
}
