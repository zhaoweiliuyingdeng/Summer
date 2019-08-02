package com.zw.dinner;
/**
 * 哲学家问题
 * 最多两人同时进行吃饭和思考
 * @author 赵薇
 *
 */

	/* 每一个哲学家相当于一个线程 */
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
				sleep(3000L) ;//模拟吃饭占用资源时间
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void thinking() {
			System.out.println(name+": I am thinking");
			try {
				sleep(3000L);//模拟思考占用资源时间
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Fork {
		//五只筷子，初始都未被使用
		private boolean[] used = {false,false,false,false,false} ;
		/**
		 * 只有当左右手的筷子都未被使用时，才可以获得筷子
		 */
		public synchronized void takeFork() {
			String name = Thread.currentThread().getName() ;
			int i = Integer.parseInt(name) ;
			while(used[i] || used[(i+1)%5]) {
				try {
					wait() ;//如果左右手有一只正在使用，则不可以获取筷子，等待
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			used[i] = true ;
			used[(i+1)%5] = true ;
		}
		/**
		 * 同时释放左右手的筷子
		 */
		public synchronized void putFork() {
			String name = Thread.currentThread().getName() ;
			int i = Integer.parseInt(name) ;
			used[i] = false ;
			used[(i+1)%5] = false ;
			notifyAll() ; //唤醒其他线程
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
