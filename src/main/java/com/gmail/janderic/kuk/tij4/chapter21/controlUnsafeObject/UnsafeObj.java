package com.gmail.janderic.kuk.tij4.chapter21.controlUnsafeObject;

/**
 * 一个非线程安全的对象
 * @author cenjv
 */
public class UnsafeObj {
	private int x, y;
	
	public UnsafeObj(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public UnsafeObj() {
		this(0, 0);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void incrementX() {
		this.x++;
	}
	
	public void incrementY() {
		this.y++;
	}
	
	@Override
	public String toString() {
		return "x="+this.x+", y="+this.y;
	}
	
	public void checkXAndY() {
		if(this.x != this.y) {
			System.err.println("x!=y."+this);
			throw new RuntimeException("x!=y."+this);
		}
	}
}
