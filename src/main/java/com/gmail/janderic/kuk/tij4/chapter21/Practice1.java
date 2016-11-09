package com.gmail.janderic.kuk.tij4.chapter21;
/**
 * thinking in java 4th 并发第一节第一个练习
 * @author JC
 * 
 * 创建5个线程结果如下（结果不固定）：
Task: #0 RUN:
Task: #1 RUN:
Task: #2 RUN:
Task: #0 {3}
Task: #0 {2}
Task: #0 {1}
Task: #0 is terminate.
Task: #1 {3}
Task: #1 {2}
Task: #1 {1}
Task: #1 is terminate.
Task: #3 RUN:
Task: #2 {3}
Task: #2 {2}
Task: #2 {1}
Task: #2 is terminate.
Task: #4 RUN:
Task: #3 {3}
Task: #3 {2}
Task: #3 {1}
Task: #3 is terminate.
Task: #4 {3}
Task: #4 {2}
Task: #4 {1}
Task: #4 is terminate.
 * 
 * 结果：在当前执行线程终止前都会至少启动一个线程作为下一个执行者，直到不再创建新的线程
 * 
 * 
 */
public class Practice1 implements Runnable {
	
	private int count = 3;
	private static int task = 0;
	private final int taskNo = task++;
	
	public Practice1() {
		System.out.println("Task: #"+taskNo+" RUN:");
	}
	
	@Override
	public void run() {
		while (count-- > 0) {
			System.out.println("Task: #"+taskNo+" {"+(count)+"}");
			if(count==0)
				System.out.println("Task: #"+taskNo+" is terminate.");
			Thread.yield();
		}
	}
	
}
