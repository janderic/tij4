package com.gmail.janderic.kuk.tij4.chapter21.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Types Practice22v2
 * @Description 这是忙等待的例子对应的wait\notify版本
 * @author juchen
 * @date 2016年11月19日 上午11:51:02
 */
public class Practice22v2 {
    
    static volatile Boolean GLOBAL_FLAG = false;
    
    static class T1 implements Runnable {
	@Override
	public void run() {
//	    while (true) {
		synchronized (this) {
		    System.out.println("GLOBAL_FLAG == "+GLOBAL_FLAG+"了，T1将GLOBAL_FLAG设置成true，开始wait()");
		    try {
			GLOBAL_FLAG = true;
			wait();// 理论上wait前也可以有条件
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		    System.out.println("T1再次被唤醒");
		}
//	    }
	}
    }
    
    static class T2 implements Runnable {
	
	private T1 t1;
	
	public T2(T1 t1) {
	    this.t1 = t1;
	}
	
	@Override
	public void run() {
	    while (true) {
		synchronized (t1) {
		    while (GLOBAL_FLAG == true) {// notify前的条件
			System.out.println("GLOBAL_FLAG == true了，T2获取t1锁，重新将GLOBAL_FLAG设置成false，并唤醒t1");
			GLOBAL_FLAG = false;
			t1.notify();
		    }
		}
	    }
	}
    }
    
    public static void main(String[] args) {
	ExecutorService pool = Executors.newCachedThreadPool();
	T1 t1 = new T1();
	pool.execute(t1);
	pool.execute(new T2(t1));
	pool.shutdown();
    }
}
