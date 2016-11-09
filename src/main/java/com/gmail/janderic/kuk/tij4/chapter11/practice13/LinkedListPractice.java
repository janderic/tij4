package com.gmail.janderic.kuk.tij4.chapter11.practice13;

import java.util.LinkedList;

public class LinkedListPractice {
    private static final void p(Object o) {
	System.out.println(o);
    }
    
    public static void main(String[] args) {
	LinkedList<String> list = new LinkedList<>();
	
	// 推到最后 linkLast()
	list.add("add1");
	list.add("add2");
	list.add("add3");
	p(list);

	// 推到栈顶 linkFirst()
	list.push("push1");
	list.push("push2");
	list.push("push3");
	p(list);
	
	// 同add
	list.offer("offer1");
	list.offer("offer2");
	list.offer("offer3");
	p(list);
	
	// 同getFirst()，只取第一个，不移除项
	p(list.element());// 取不到抛NoSuchElementException
	p(list.peek());// 取不到返回null，和peekFirst()的内容一样一样的。。
	
	// 弹出栈顶（返回并移除），unlinkFirst()
	p(list.remove());
	p(list.remove());
	p(list.remove());
	p(list);
	
	p(list.pop());// 同remove()，失败抛NoSuchElementException
	p(list.poll());// 失败返回null，和pollFirst()的内容一样一样的。。
	p(list);
	
    }
}
