package com.zw.dinner;
/**
 * ��ѧ������
 * �������ͬʱ���гԷ���˼��
 * @author ��ޱ
 *
 */

	/* ÿһ����ѧ���൱��һ���߳� */
	class Philosopher extends Thread{
		private String name ;
		private Fork fork ;
		public Philosopher(String name,Fork fork){
	        super(name);
	        this.name=name;
	        this.fork=fork;
	    }
		public void run() {
			while(true) {
				thinking() ;
				fork.takeFork();
				eatting() ;
				fork.putFork();
			}
		}
		
		public void eatting() {
			System.out.println(name+": I am eatting");
			try {
				sleep(3000L) ;//ģ��Է�ռ����Դʱ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void thinking() {
			System.out.println(name+": I am thinking");
			try {
				sleep(3000L);//ģ��˼��ռ����Դʱ��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Fork {
		//��ֻ���ӣ���ʼ��δ��ʹ��
		private boolean[] used = {false,false,false,false,false} ;
		/**
		 * ֻ�е������ֵĿ��Ӷ�δ��ʹ��ʱ���ſ��Ի�ÿ���
		 */
		public synchronized void takeFork() {
			String name = Thread.currentThread().getName() ;
			int i = Integer.parseInt(name) ;
			while(used[i] || used[(i+1)%5]) {
				try {
					wait() ;//�����������һֻ����ʹ�ã��򲻿��Ի�ȡ���ӣ��ȴ�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			used[i] = true ;
			used[(i+1)%5] = true ;
		}
		/**
		 * ͬʱ�ͷ������ֵĿ���
		 */
		public synchronized void putFork() {
			String name = Thread.currentThread().getName() ;
			int i = Integer.parseInt(name) ;
			used[i] = false ;
			used[(i+1)%5] = false ;
			notifyAll() ; //���������߳�
		}
	}
public class ThreadTest {
	public static void main(String[] args) {
		    Fork fork = new Fork();
	        new Philosopher("0",fork).start();
	        new Philosopher("1",fork).start();
	        new Philosopher("2",fork).start();
	        new Philosopher("3",fork).start();
	        new Philosopher("4",fork).start();
	}

}
