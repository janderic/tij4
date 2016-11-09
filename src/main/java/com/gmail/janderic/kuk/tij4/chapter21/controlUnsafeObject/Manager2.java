package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

public class Manager2 extends UnsafeObjManager {

	@Override
	protected void increment() {
		UnsafeObj obj;
		synchronized (this) {
			unsafeObj.incrementX();
			unsafeObj.incrementY();
			obj = this.getObj();// 赋值需要放在同步块中
		}
		store(obj);
	}

}
