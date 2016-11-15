/**
 * 
 */
package com.gmail.janderic.kuk.tij4.chapter21.join;

/**
 * @Types ThreadB
 * @Description 
 * @author juchen
 * @date 2016年11月14日 上午9:43:16
 */
public class ThreadB implements Runnable {

    private static final int EXECUTE_COUNT = 4;
    
    private Thread c;
    
    public ThreadB(Thread c) {
//	System.out.println("Thread B start.");
	this.c = c;
    }
    
    @Override
    public void run() {
	try {
	    c.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("Thread C 执行完毕，Thread B 继续执行");
	for (int i = 1; i <= EXECUTE_COUNT; i++) {
	    System.out.println("Thread B 执行第 "+i+" 次");
	}
    }

}
