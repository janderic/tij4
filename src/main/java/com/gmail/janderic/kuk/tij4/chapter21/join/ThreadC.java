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
public class ThreadC implements Runnable {

    private static final int EXECUTE_COUNT = 4;
    
    public ThreadC() {
//	System.out.println("Thread B start.");
    }
    
    @Override
    public void run() {
	for (int i = 1; i <= EXECUTE_COUNT; i++) {
	    System.out.println("Thread C 执行第 "+i+" 次");
	}
    }

    public static void main(String[] args) {
	Thread b = new Thread(new ThreadC(), "C Thread");
	b.start();
    }
}
