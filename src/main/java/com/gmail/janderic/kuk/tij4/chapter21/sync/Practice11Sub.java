package com.gmail.janderic.kuk.tij4.chapter21.sync;


public class Practice11Sub {
	
	public synchronized void counterAdd() {
		counter1++;
		Thread.yield();// 此时应该不会切换，因为没释放锁
		counter1++;
	}
	
	private int counter1 = 0;

	public /*synchronized*/ int getCounter1() {
		return counter1;
	}

	public void setCounter1(int counter1) {
		this.counter1 = counter1;
	}

}
