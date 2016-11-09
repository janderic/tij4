/**
 * 
 */
package com.gmail.janderic.kuk.tij4.chapter9.practice1;

/**
 * @Types Mouse
 * @Description 
 * @author juchen
 * @date 2016年11月4日 下午4:14:45
 */
public class Mouse extends Rodent {
    private int i = 1;
    
    public static void staticFun(Rodent r) {
	
    }
    
    protected void run() {
	System.out.println(i);
    }
    
    public static void main(String[] args) {
	Mouse m = new Mouse();
	m.run();
    }
}
