package com.gmail.janderic.kuk.tij4.chapter21.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task implements Runnable {

    private NonTask nonTask = new NonTask();
    
    @Override
    public void run() {
	try {
	    nonTask.sleepMethod();
	} catch (InterruptedException e) {
	    System.out.println("被打断");
	} finally {
	    System.out.println("执行清理");
	}
    }
    
    public static void main(String[] args) {
//	Task task = new Task();
//	Thread t = new Thread(task);
//	t.start();
//	
//	t.interrupt();
	ExecutorService e = Executors.newCachedThreadPool();
	e.execute(new Task());
	e.shutdownNow();
    }

}
