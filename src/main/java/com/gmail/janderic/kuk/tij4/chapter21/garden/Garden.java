package com.gmail.janderic.kuk.tij4.chapter21.garden;

import java.util.concurrent.TimeUnit;

public class Garden {

    public static void main(String[] args) {
	Counter counter = new Counter();
	Entrance north = new Entrance(counter, "北门");
	Entrance south = new Entrance(counter, "南门");
	
	Thread t1 = new Thread(north);
	t1.start();
	Thread t2 = new Thread(south);
	t2.start();
	
	try {
	    TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	System.out.println(String.format("花园总人数：%d人", counter.value()));
    }

}
