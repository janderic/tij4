package com.gmail.janderic.kuk.tij4.chapter21.interrupt;

import java.util.concurrent.TimeUnit;

public class NonTask {
    public void sleepMethod() throws InterruptedException {
	System.out.println("NonTask.sleepMethod running 5s.");
	TimeUnit.SECONDS.sleep(5);
	System.out.println("sleepMethod() over.");
    }
}
