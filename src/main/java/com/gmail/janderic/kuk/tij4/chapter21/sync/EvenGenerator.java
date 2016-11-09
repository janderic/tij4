package com.gmail.janderic.kuk.tij4.chapter21.sync;

public class EvenGenerator extends IntGenerator {

	private int num = 0;
	
	@Override
	protected int next() {
		++num;
		++num;
		return num;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator(), 10);
	}
}
