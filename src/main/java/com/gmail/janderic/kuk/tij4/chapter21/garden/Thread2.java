package com.gmail.janderic.kuk.tij4.chapter21.garden;

import java.util.concurrent.TimeUnit;

public class Thread2 implements Runnable {

	private final int no;
	private Count t;
	
	Thread2(Count t, int no) {
		this.t = t;
		this.no = no;
	}

	@Override
	public void run() {
		int num = t.getNum();
		while(num >= 0) {
			t.subsub();
			System.out.println("#"+no+"--:"+num);
			/*try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

}
