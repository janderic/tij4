package com.gmail.janderic.kuk.tij4.chapter21.dcl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Service {
	
	public Service(Long id) {
		this.id = id;
	}
	
	private Long id;
	
	public void xxx(Thread which) {
		System.out.println(which.getName() + "准备获取锁");
		synchronized (id) {
			Random r = new Random();
			int second = r.nextInt(4);
			System.out.println(which.getName() + "xxx等待"+second+"s");
			try {
				TimeUnit.SECONDS.sleep(second);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(which.getName() + "释放锁");
	}
}
