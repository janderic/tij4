package com.gmail.janderic.kuk.tij4.chapter21.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice21 {
    
    static class T1 implements Runnable {
	@Override
	public void run() {
	    synchronized (this) {
		System.out.println("T1获得自己锁，准备wait()");
		try {
		    wait();
		} catch (InterruptedException e) {
		    System.out.println("wait被中断");
		} finally {
		    System.out.println("wait finally.");
		}
		System.out.println("退出T1.run()");
	    }
	}
    }
    
    static class T2 implements Runnable {
	private T1 t1;
	
	public T2(T1 t1) {
	    this.t1 = t1;
	}
	
	@Override
	public void run() {
	    synchronized (t1) {
		System.out.println("T2获取t1锁，准备通知t1恢复wait");
		t1.notifyAll();
	    }
	}
    }
    
    public static void main(String[] args) {
	ExecutorService pool = Executors.newCachedThreadPool();
	T1 t1 = new T1();
	pool.execute(t1);
	pool.execute(new T2(t1));
	pool.shutdown();
	/**
	 * 如果上面的代码两条线程执行顺序互换，即先t2-再t1，则会出现死锁！
	 * 先来看下调用顺序：
	 * 1.先t2.run()，此时t2获得t1锁，调用t1.notifyAll()，t2线程从run()中返回
	 * 2.t1获得锁，调用wait()，t1线程释放锁，并等待其他线程唤醒自己
	 * t2先于t1执行，盲目调用t1的notifyAll()方法，并没有起到实际唤醒t1线程的作用（此时t1还没有获取锁并wait()），
	 * 当t1真正得到锁并wait()后，由于没有其他线程的介入，整个程序便会死锁在这里。
	 * 
	 * 当使用wait\notify\notifyAll时，需要注意：在调用这些方法前加入一些前提条件，在满足条件的情况下再去调用这些方法！
	 */
    }
}
