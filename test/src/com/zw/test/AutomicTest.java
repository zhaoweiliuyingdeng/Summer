package com.zw.test;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicTest {
	public AtomicInteger inc = new AtomicInteger() ;
	public void increase() {
		inc.getAndIncrement() ;
	}

	public static void main(String[] args) {
		final AutomicTest test = new AutomicTest() ;
		for(int i = 0 ; i < 10 ; i++) {
			new Thread() {
				public void run() {
					for(int j = 0 ; j < 1000 ; j++) {
						test.increase();
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
