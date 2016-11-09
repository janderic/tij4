package com.gmail.janderic.kuk.tij4.chapter21.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bean {
	private Map<String, Integer> map = new ConcurrentHashMap<>();
	
	public  void add(String key) {
		Integer value = map.get(key);
		if(value == null)
			map.put(key, 1);
		else
			map.put(key, value + 1);
	}
	
	public  void sysout() {
		System.out.println(Thread.currentThread().toString()+map);
	}
}
