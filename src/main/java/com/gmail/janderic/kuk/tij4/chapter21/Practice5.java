package com.gmail.janderic.kuk.tij4.chapter21;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.gmail.janderic.kuk.tij4.chapter15.Generator;

public class Practice5 implements Callable<Integer>, Generator<Integer> {

    private int count;
    private int n;
    
    public Practice5() {
    }
    
    public Practice5(int n) {
	this.n = n;
    }
    
    private int fib(int c) {
	if (c < 2)
	    return 1;
	return fib(c - 2) + fib(c - 1);
    }

    @Override
    public Integer next() {
	return fib(count++);
    }
    
//    @Override
//    public void run() {
//	int[] fibarray = new int[n];
//	int total = 0;
//	for (int i = 0; i < n; i++) {
//	    fibarray[i] = next();
//	    total += next();
//	}
//	System.out.println(Arrays.toString(fibarray));
//    }

    @Override
    public Integer call() throws Exception {
	int[] fibarray = new int[n];
	int total = 0;
	for (int i = 0; i < n; i++) {
	    fibarray[i] = next();
	    total += fibarray[i];
	}
//	this.total = total;
	System.out.println(Arrays.toString(fibarray));
    
	return total;
    }
    
    public static void main(String[] args) {
	Practice5 practice5 = new Practice5(5);
	ExecutorService exe = Executors.newCachedThreadPool();
	for (int i = 0; i < 4; i++) {
	    // 还有一种方式使用FutureTask<T>
	    Future<Integer> submit = exe.submit(practice5);
	    try {
		System.out.println(submit.get());
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    } catch (ExecutionException e) {
		e.printStackTrace();
	    }
	}
	exe.shutdown();
    }
}