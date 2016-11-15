package com.gmail.janderic.kuk.tij4.chapter17;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Practice12<K, V> {
    private Map<K, V> map;
    private Class<?> type;
    
    public Practice12(Class<? extends AbstractMap<K, V>> type) {
	this.type = type;
	try {
	    this.map = type.newInstance();
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	}
    }
    
    public Class<?> getType() {
        return type;
    }

    public void put(K key, V value) {
	map.put(key, value);
    }
    
    public V get(K key) {
	return map.get(key);
    }
    
    @Override
    public String toString() {
	return map.toString();
    }
    
    public static void main(String[] args) {
	Practice12<String, Integer> hashMap = new Practice12(HashMap.class);
	Practice12<String, Integer> treeMap = new Practice12(TreeMap.class);
	Practice12<String, Integer> linkedHashMap = new Practice12(LinkedHashMap.class);
	List<Practice12<String, Integer>> list = Arrays.asList(hashMap, treeMap, linkedHashMap);
	for (Practice12<String, Integer> map : list) {
	    map.put("juchen", 28);
	    map.put("jumingzhou", 5);
	    map.put("zhouxialing", 28);
	    map.put("zhouailing", 26);
	    map.put("dongxiaobin", 48);
	    System.out.println(map.getType().getSimpleName()+", "+map);
	}
    }
}
