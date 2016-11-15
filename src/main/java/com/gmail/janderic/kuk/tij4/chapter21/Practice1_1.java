package com.gmail.janderic.kuk.tij4.chapter21;

public class Practice1_1 implements Runnable {

    private static int ii = 0;
    private final int no = ii++;
    
    private int eachNum = 3;
    
    public Practice1_1() {
	System.out.println(String.format("#{%d} start.", no));
    }
    
    @Override
    public void run() {
	for (int i = 0; i < eachNum; i++) {
	    System.out.println(String.format("#{%d}-%d", no, i));
	    Thread.yield();
	}
	System.out.println(String.format("#{%d} over.", no));
    }

    public static void main(String[] args) {
	for (int i = 0; i < 4; i++) {
	    new Thread(new Practice1_1()).start();
	}
    }

}
