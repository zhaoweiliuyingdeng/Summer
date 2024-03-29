package com.zw.test;

public class VolatileTest {
	public volatile int inc = 0 ;
	public void increse() {
		inc ++ ;
	}

	public static void main(String[] args) {
		final VolatileTest test = new VolatileTest() ;
		for(int i = 0 ; i < 10 ; i++) {
			new Thread() {
				public void run() {
					for(int j = 0 ; j < 1000 ; j++) {
						test.increse();
					}
				}
			}.start();
		}
		while(Thread.activeCount() > 1) {
			Thread.yield();
			System.out.println(test.inc);
		}

	}

}
