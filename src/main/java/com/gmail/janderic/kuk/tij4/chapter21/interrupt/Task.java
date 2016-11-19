package com.gmail.janderic.kuk.tij4.chapter21.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    private NonTask nonTask = new NonTask();
    
    private String name;
    
    public Task(String name) {
	this.name = name;
    }
    
    @Override
    public void run() {
	try {
	    nonTask.sleepMethod();
	} catch (InterruptedException e) {
	    System.out.println(name+"被打断");
	}/* finally {
	    System.out.println(name+"执行清理");
	}*/
	System.out.println(name+" 退出 run()方法");
    }
    
    public static void main(String[] args) throws InterruptedException {
//	Task task = new Task();
//	Thread t = new Thread(task);
//	t.start();
//	
//	t.interrupt();
	ExecutorService e = Executors.newCachedThreadPool();
	Future<?> future = e.submit(new Task("线程1"));
	e.submit(new Task("线程2"));
	
	System.out.println("3秒后中断线程1");
	TimeUnit.SECONDS.sleep(3);
	future.cancel(true);
	
	
//	System.out.println("3秒后中断线程池中所有线程");
//	TimeUnit.SECONDS.sleep(3);
//	e.shutdownNow();
    }

}
