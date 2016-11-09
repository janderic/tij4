package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

public class Thread2 implements Runnable {
	
	UnsafeObjManager unsafeObjManager;

	public Thread2(UnsafeObjManager unsafeObjManager) {
		this.unsafeObjManager = unsafeObjManager;
	}
	
	@Override
	public void run() {
		while (true) {
			unsafeObjManager.i.incrementAndGet();// 每次检查都自增检查次数
			unsafeObjManager.getObj().checkXAndY();
		}
	}
	
}
