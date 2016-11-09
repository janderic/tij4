package com.gmail.janderic.kuk.tij4.chapter21.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService e = Executors.newCachedThreadPool();
		
		Runnable task1 = new Runnable() {
			public void run() {
				System.out.println("i'm task1.");
			}
		};
		
		Callable<Integer> task2 = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return new Integer(100);
			}
		};
		
		Future<?> f1 = e.submit(task1);
		Future<Integer> f2 = e.submit(task2);
		
		System.out.println("f1 is done?"+f1.isDone());
		System.out.println("f2 is done?"+f2.isDone());
		
		while (f1.isDone()) {
			System.out.println("f1 done.");
			break;
		}
		while (f2.isDone()) {
			System.out.println("return value by f2:"+(f2.get().toString()));
			break;
		}
		
		
	}
}
