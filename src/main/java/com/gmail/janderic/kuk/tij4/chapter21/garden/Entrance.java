package com.gmail.janderic.kuk.tij4.chapter21.garden;

import java.util.Random;

/**
 * @Types Entrance
 * @Description 入口
 * @author juchen
 * @date 2016年11月14日 下午9:09:38
 */
public class Entrance implements Runnable {

    private Counter counter;
    private String name;
    
    public Entrance(){}
    public Entrance(Counter counter, String name) {
	this.counter = counter;
	this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void run() {
	Random r = new Random();
	int times = r.nextInt(50);
	System.out.println(String.format("%s 开始进人..预计进入 %d 人", name, times));
	while (times-->0) {
	    counter.in();
	}
	int out = r.nextInt(10);
	System.out.println(String.format("%s 开始出人..预计走出 %d 人", name, out));
	while (out-->0) {
	    counter.out();
	}
    }

}
