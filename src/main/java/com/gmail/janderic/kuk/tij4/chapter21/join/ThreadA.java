/**
 * 
 */
package com.gmail.janderic.kuk.tij4.chapter21.join;

/**
 * @Types ThreadA
 * @Description 通过join 使线程A B C依次执行
 * @author juchen
 * @date 2016年11月14日 上午9:43:16
 */
public class ThreadA implements Runnable {

    private static final int EXECUTE_COUNT = 4;
    
    private Thread threadB;
    
    public ThreadA(Thread threadB) {
//	System.out.println("Thread A start.");
	this.threadB = threadB;
    }
    
    @Override
    public void run() {
	
	try {
	    threadB.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	System.out.println("Thread B 执行完毕，Thread A 继续执行");
	for (int i = 1; i <= EXECUTE_COUNT; i++) {
	    System.out.println("Thread A 执行第 "+i+" 次");
	}
    }

    public static void main(String[] args) {
	Thread c = new Thread(new ThreadC(), "C Thread");
	c.start();
	Thread b = new Thread(new ThreadB(c), "B Thread");
	b.start();
	Thread a = new Thread(new ThreadA(b), "A Thread");
	a.start();
//	System.out.println("最后轮到主线程执行");
//	System.out.println(Thread.currentThread().getName());
    }
}
