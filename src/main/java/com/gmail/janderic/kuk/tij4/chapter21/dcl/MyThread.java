package com.gmail.janderic.kuk.tij4.chapter21.dcl;

public class MyThread implements Runnable {

	private Service service;
	
	public MyThread(Service service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		while (true) {
			service.xxx(Thread.currentThread());
		}
	}

}
