package com.gmail.janderic.kuk.tij4.chapter21.bank;

import java.util.concurrent.TimeUnit;

public class Trans {
	
	private Account account;// 账户
	
	Trans(Account account) {
		this.account = account;
	}

	public void add(int addMoney) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		account.setMoney(account.getMoney() + addMoney);
	}
	
	public void subtract(int subMoney) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		account.setMoney(account.getMoney() - subMoney);
	}
	
}
