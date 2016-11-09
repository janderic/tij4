package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.concurrent.TimeUnit;


public class Doing {
	
	private byte[] lock = new byte[0];
	
	public void doingMethodSync(String name) {// 实例级
		synchronized (this) {// 等同于在方法上直接使用synchronized关键字
			sysout(name);
		}
	}
	
	public void doingPart(String name) {// 实例级
		synchronized (lock) {// 局部同步
			sysout(name);
		}
	}
	
	public void doingPartClass(String name) {// Class级
		synchronized (Doing.class) {// 局部同步
			sysout(name);
		}
	}
	
	public synchronized static void doingPartStatic(String name) {// Class级，等同doingPartClass
		try {
			System.out.println(name+" 进入WC，其他人等退下！");
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+" 结束，此时换人。");
	}


	private void sysout(String name) {
		try {
			System.out.println(name+" 进入WC，其他人等退下！");
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+" 结束，此时换人。");
	}
	
}
