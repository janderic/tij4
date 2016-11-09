/**
 * 
 */
package com.gmail.janderic.kuk.tij4.chapter11.practice15;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Types Stack
 * @Description 一个使用LinkedList封装的栈（LIFO），非线程安全
 * @author juchen
 * @date 2016年11月7日 下午8:03:17
 */
public class Stack<T> extends AbstractCollection<T> {

    private LinkedList<T> list;
    
    public Stack() {
	super();
	list = new LinkedList<>();
    }
    
    public Stack(Collection<? extends T> c) {
	list = new LinkedList<>(c);
    }
    
    /**
     * 栈顶压入
     * @param e
     */
    public void push(T e) {
	list.push(e);
    }
    
    /**
     * 弹出栈顶并返回
     * @return
     */
    public T pop() {
	return list.pop();
    }
    
    /**
     * 偷窥一下栈顶元素。。
     * 只偷窥一下:D 什么也不干
     * @return
     */
    public T peeeeeeeek() {
	return list.peek();
    }
    
    @Override
    public Iterator<T> iterator() {
	return list.iterator();
    }

    @Override
    public int size() {
	return list.size();
    }
    
}
