package com.gmail.janderic.kuk.tij4.chapter21.interrupt;

import java.util.concurrent.TimeUnit;

public class NonTask {
    public void sleepMethod() throws InterruptedException {
	System.out.println("sleepMethod() start.");
	System.out.println("sleepMethod() over.");
    }
}
