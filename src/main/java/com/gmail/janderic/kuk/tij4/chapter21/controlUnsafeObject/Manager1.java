package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

public class Manager1 extends UnsafeObjManager {

	@Override
	protected synchronized void increment() {
		unsafeObj.incrementX();
		unsafeObj.incrementY();
		store(getObj());
	}

}
