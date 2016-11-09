package com.gmail.janderic.kuk.tij4.chapter21.garden;


public class Thread1 implements Runnable {
	
	private final int no;
	private Count t;
	
	Thread1(Count t, int no) {
		this.t = t;
		this.no = no;
	}

	@Override
	public void run() {
		
		while(!t.isCancel) {
			t.increment();
			t.subsub();
			int num = t.getNum();
			if(num != 0) {
				System.out.println("#"+no+"非0："+num);
				t.cancel();
			}
		}
		System.out.println("#"+no+" return");
	}

}
