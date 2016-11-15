package com.gmail.janderic.kuk.tij4.chapter21.garden;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    
    private AtomicInteger total = new AtomicInteger(0);
    
    public void in() {
	total.incrementAndGet();
    }
    public void out() {
	total.decrementAndGet();
    }
    
    public synchronized int value() {
	return total.get();
    }
}
