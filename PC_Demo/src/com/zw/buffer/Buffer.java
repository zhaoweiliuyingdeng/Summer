package com.zw.buffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 缓存区类
 * @author 赵薇
 *
 */
public class Buffer {
	//读取数据的缓存区
	private volatile byte[] bytes = new byte[1024] ;
	
	//信号灯法，判断该线程是生产还是消费
	private boolean flag = false ;
	
	//读取的字节数，因为这里的生产行为是读取文件的数据，所以每次读取的时候，都从上次读的位置开始
	private int pos = 0 ; 
	
	/**
	 * 信号灯法的核心：
	 * 如果flag为真，那么消费者消费。生产者等待
	 * 如果flag为假，那么生产者生产，消费者等待
	 * 线程的等待用wait，唤醒用notify
	 */
	//生产行为
	public synchronized int product(File file) {
		if(flag) {
			try {
				//flag为真，生产者等待
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//flag为假，生产者生产，也就是读取文件的数据到缓存区
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//读取数据到缓存区，接收每次读取的字节数
			pos = read(file) ;
			
			//生产完毕后，生产者在次等待
			flag = true ;
			//并唤醒消费者消费
			this.notify();

			//返回每次读取的字节数，如果读取到文件的末尾，返回-1 ，
			//这也是作为生产者停止的条件
		return pos ;
	}

	//消费行为
	public synchronized void consume() {
		if(!flag) {
			//flag为假，消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//flag为真，消费者消费
		try {
			//每次消费休眠1000ms
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//消费，就是从缓存里读取数据，输出到控制台
		prints() ;
		
		//消费者再次等待
		flag = false ;
		
		//唤醒生产者
		this.notify();
		
	}
	/**
	 * 输出方法，每次读取完后，将缓存置为空
	 * 不断的写入和读取数据
	 */
	private void prints() {
		// TODO Auto-generated method stub
		try {
			System.out.println(new String(bytes,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bytes = null ;
		bytes = new byte[1024] ;
	}

	//读取数据的方法
	private int read(File file) {
		//利用RandomAccessFile类可以定位到上次读取文件的位置
		
		try {
			RandomAccessFile rf = new RandomAccessFile(file,"r") ;
			
			//设置流到文件指针的位置，每次流就会从此位置开始读取
				rf.seek(pos);
				pos = rf.read(bytes) ;
			//如果指针为-1 ， 读到了文件末尾，直接返回
				if(-1 == pos) {
					return -1 ;
					
				}else {
					pos = (int)rf.getFilePointer() ;
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回文件指针
		return pos;
	}

}
