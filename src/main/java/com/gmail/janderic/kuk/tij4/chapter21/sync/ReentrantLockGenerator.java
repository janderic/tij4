package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockGenerator extends IntGenerator{
	
	private int i = 0;
	
	private Lock lock = new ReentrantLock();

	@Override
	protected int next() {
		lock.lock();
		try {
			++i;
			Thread.yield();
			++i;
			return i;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new ReentrantLockGenerator(), 10);
	}
}
