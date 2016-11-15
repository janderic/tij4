package com.gmail.janderic.kuk.tij4.chapter21;

import java.util.Arrays;

import com.gmail.janderic.kuk.tij4.chapter15.Generator;

/**
 * @Types Practice1_2
 * @Description Fibonacci数字序列
 * @author juchen
 * @date 2016年11月13日 下午4:40:38
 */
public class Practice1_2 implements Generator<Integer>, Runnable {

    private int count;
    private int n;
    
    public Practice1_2(int n) {
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
    
    @Override
    public void run() {
	int[] fibarray = new int[n];
	for (int i = 0; i < n; i++) {
	    fibarray[i] = next();
	}
	System.out.println(Arrays.toString(fibarray));
    }
    
    public static void main(String[] args) {
//	Practice1_2 f = new Practice1_2(20);
	for (int i = 0; i < 5; i++) {

//	    new Thread(f).start();
	     new Thread(new Practice1_2(i+1)).start();
	}
    }
}
