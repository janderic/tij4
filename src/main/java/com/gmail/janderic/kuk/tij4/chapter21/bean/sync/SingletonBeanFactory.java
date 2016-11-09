package com.gmail.janderic.kuk.tij4.chapter21.bean.sync;

import java.util.HashMap;
import java.util.Map;

public enum SingletonBeanFactory {

    INSTANCE;

    private final Map<Class<?>, Object> singletonBeans = new HashMap<>(10000000);

    protected void registerBean(Class<?> clazz) {
        try {
        	Object newInstance = clazz.newInstance();
        	System.out.println("registerBean::"+newInstance);
        	singletonBeans.put(clazz, newInstance);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

	public Object getBean(Class<?> clazz) {
		synchronized (clazz) {
			if (!isSingleton(clazz)) {
				registerBean(clazz);
			}
		}
			return singletonBeans.get(clazz);
	}

    public boolean isSingleton(Class<?> clazz) {
        return singletonBeans.containsKey(clazz);
    }

}
