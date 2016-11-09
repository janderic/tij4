package com.gmail.janderic.kuk.tij4.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practive2 implements Runnable {
	private static int i = 0;
	private final int No = i++;
	
	private Person person;
	
	static List<Person> personList = new ArrayList<>();
	
	public Practive2(Person person) {
		this.person = person;
	}

	@Override
	public void run() {
		personList.add(person);

		synchronized (personList) {
			for (Person p : personList) {
				System.out.println("id:"+p.getId()+", name:"+p.getName());
			}
			System.out.println("------------------------------------");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			e.execute(new Practive2(new Person((long)i, i+"x")));
		}
		e.shutdown();
//		for (Person p : Practive2.personList) {
//			System.out.println("id:"+p.getId()+", name:"+p.getName());
//		}
	}
}
