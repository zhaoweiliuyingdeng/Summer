package com.zw.product;

import java.io.File;

import com.zw.buffer.Buffer;
/**
 * 生产者类
 * @author 赵薇
 *
 */
public class Producter extends Thread {
	private Buffer buf ;
	public Producter(Buffer buf) {
		this.buf = buf ;
	}
	@Override
	public void run() {
		super.run();
		int judge = 0 ;
		
		while(-1 != judge) {
			judge = buf.product(new File("E:\\IDEA\\out\\production\\com.xupt.sort\\com\\xupt\\sort")) ;
		}
	}

}
