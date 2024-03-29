package com.zw.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public int inc = 0 ;
	Lock lock = new ReentrantLock() ;
	public void increase() {
		lock.lock();
		try {
			inc++;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final LockTest test = new LockTest() ;
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
