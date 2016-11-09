package com.gmail.janderic.kuk.tij4.chapter21.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {
	
	static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
	
	static final long CONSUMER_INTERV = 4l;
	static final long PRODUER_INTERV = 5l;
	
	public static void main(String[] args) throws InterruptedException {
		Consumer c = new Consumer();
		Produer p = new Produer();
		new Thread(c).start();
		new Thread(p).start();
	}
	
	static class Consumer implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(CONSUMER_INTERV);
					System.out.println("消费者每"+CONSUMER_INTERV+"s消费一次");
					queue.take();
					sysoutQueue();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	static class Produer implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println("生产者每"+PRODUER_INTERV+"s生产一个");
				try {
					queue.put(String.valueOf(System.currentTimeMillis()));
					sysoutQueue();
					TimeUnit.SECONDS.sleep(PRODUER_INTERV);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static void sysoutQueue() {
		System.out.println(queue);
	}
}
