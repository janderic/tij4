package com.gmail.janderic.kuk.tij4.chapter21;

public class ExtThread extends Thread {
    
    private int tickets = 10;
    
    @Override
    public void run() {
	while(tickets-->0) {
	    System.out.println(String.format(this+"剩余票数：%d", tickets));
	}
    }

    public static void main(String[] args) {
	ImplRunnable target = new ImplRunnable();
	for (int i = 0; i < 4; i++) {
//	    new ExtThread().start();
	    new Thread(target).start();
	}
    }
    
    static class ImplRunnable implements Runnable {

	private Integer rTickets = 10;

	@Override
	public void run() {
	    synchronized (this) {
		while (rTickets-- > 0) {
		    System.out.println(String.format(this + "剩余票数：%d", rTickets));
		}
	    }
	}
	
	

    }
}
