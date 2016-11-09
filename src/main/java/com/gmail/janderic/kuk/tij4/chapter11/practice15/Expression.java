/**
 * 
 */
package com.gmail.janderic.kuk.tij4.chapter11.practice15;

/**
 * @Types Expression
 * @Description 
 * @author juchen
 * @date 2016年11月7日 下午8:59:51
 */
public class Expression {

    private static final String EXP = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
    
    private Stack<Character> stack = new Stack<>();
    
    public String resolving() {
	char[] array = EXP.toCharArray();
	for (char c : array) {
	    if(c == '-') {
		System.out.print(stack.pop());
		continue;
	    } else if(c == '+') {
		continue;
	    } else {
		stack.push(c);
	    }
	}
	return stackToString();
    }
    
    public String stackToString() {
	StringBuilder s = new StringBuilder();
	for (Character c : stack) {
	    s.append(c);
	}
	return s.toString();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	Expression e = new Expression();
	System.out.println(e.resolving());
    }

}
