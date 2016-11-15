package com.gmail.janderic.kuk.tij4.chapter15;

public class Fibonacci implements Generator<Integer> {

    private int count;
    
    private int fib(int count) {
	if (count < 2)
	    return 1;
	return fib(count - 2) + fib(count - 1);
    }
    
    @Override
    public Integer next() {
	return fib(count++);
    }
    
}