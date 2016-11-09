package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

public class Thread1 implements Runnable {

	private UnsafeObjManager unsafeObjManager;
	
	public Thread1(UnsafeObjManager unsafeObjManager) {
		this.unsafeObjManager = unsafeObjManager;
	}
	
	@Override
	public void run() {
		while (true) {
			unsafeObjManager.increment();
		}
	}
	
	@Override
	public String toString() {
		return "UnsafeObjManager:"+unsafeObjManager.unsafeObj+",i:"+unsafeObjManager.i.get();
	}

}
