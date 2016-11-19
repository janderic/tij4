package com.gmail.janderic.kuk.tij4.chapter21.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {
    
    class SleepBlock implements Runnable {
	@Override
	public void run() {
	    System.out.println("SleepBlock.running...");
	    try {
		TimeUnit.MILLISECONDS.sleep(3000);
	    } catch (InterruptedException e) {
		System.err.println("SleepBlock被中断");
	    }
	    System.out.println("Exiting SleepBlock.run()");
	}
    }
    
    class IOBlock implements Runnable {
	@Override
	public void run() {
	    
	}
    }
    
    class SynchronizedBlock implements Runnable {
	synchronized void f() {
	    while (true) {// 永远不释放锁！
		Thread.yield();
	    }
	}

	public SynchronizedBlock() {
	    new Thread() {
		@Override
		public void run() {
		    f();
		}
	    }.start();
	}
	
	@Override
	public void run() {
	    System.out.println("尝试调用f()");
	    f();
	    System.out.println("退出SynchronizedBlock.run()");
	}
    }
    
    private static ExecutorService exec = Executors.newCachedThreadPool();
    
    static void test(Runnable runable) throws InterruptedException {
	Future<?> future = exec.submit(runable);
	TimeUnit.MILLISECONDS.sleep(3000);
	String threadName = runable.getClass().getName();
	System.out.println("即将停止线程"+threadName);
	boolean cancel = future.cancel(true);
	System.out.println("调用线程["+threadName+"]完毕，结果："+cancel);
    }
    
    public static void main(String[] args) throws InterruptedException {
	Interrupting i = new Interrupting();
//	test(i.new SleepBlock());
//	test(i.new IOBlock());
	test(i.new SynchronizedBlock());
	System.out.println("5秒后关闭");
	TimeUnit.SECONDS.sleep(5);
	System.exit(0);
	
    }
}
