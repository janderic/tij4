package com.gmail.janderic.kuk.tij4.chapter12.practice19.lostmessage;

public class LostMessage {

	public void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	
	public void distory() throws HoHumException {
		throw new HoHumException();
	}
	
	public static void main(String[] args) {
		LostMessage obj = new LostMessage();
			try {
				obj.f();
			} catch (VeryImportantException e) {
				System.out.println(e);
			} finally {
				try {
					obj.distory();
				} catch (HoHumException e) {
					System.out.println(e);
				}
			}
	}

}
