package com.gmail.janderic.kuk.tij4.chapter11.practice4;

public class GenerateMovie {
    
    int index = 0;
    
    static final String[] MOVIE_DATA = {"沉默的羔羊", "肖申克的救赎", "了不起的盖茨比", "搏击俱乐部", "不可饶恕", "釜山行"};
    
    public String next() {
	if (index + 1 > MOVIE_DATA.length)
	    index = 0;
	return MOVIE_DATA[index++];
    }
    
    public static void main(String[] args) {
	GenerateMovie movie = new GenerateMovie();
	for (int i = 0; i < 10; i++) {
	    System.out.println(movie.next());
	}
    }
}
