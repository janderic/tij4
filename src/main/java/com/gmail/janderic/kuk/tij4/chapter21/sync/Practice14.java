package com.gmail.janderic.kuk.tij4.chapter21.sync;

import java.util.Timer;
import java.util.TimerTask;

public class Practice14 {
    public static void main(String[] args) {
	for (int i = 0; i < 10; i++) {
	    final int j = i;
	    new Timer().schedule(new TimerTask() {
	        
	        @Override
	        public void run() {
	            System.out.println(j);
	        }
	    }, 1000);
	    
	}
    }
}
