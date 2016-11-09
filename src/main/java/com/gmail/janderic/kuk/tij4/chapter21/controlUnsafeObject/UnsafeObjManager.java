package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 此类将持有一个非线程安全的类。目的是在本类的保护下，这个不安全的类可以应用于多线程环境
 * @author cenjv
 */
public abstract class UnsafeObjManager {
	
	AtomicInteger i = new AtomicInteger();// 检查次数，整形原子类

	protected UnsafeObj unsafeObj = new UnsafeObj();
	
	private List<UnsafeObj> syncList = Collections.synchronizedList(new ArrayList<UnsafeObj>());
	
	// 返回一个对象副本
	protected synchronized UnsafeObj getObj() {
		return new UnsafeObj(unsafeObj.getX(), unsafeObj.getY());
	}
	
	protected void store(UnsafeObj obj) {
		syncList.add(obj);// 线程安全
	}
	
	protected abstract void increment();// 模板方法
	
}
