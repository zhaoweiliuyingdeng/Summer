package com.zw.consum;

import com.zw.buffer.Buffer;

/**
 * 消费者类
 * @author 赵薇
 *
 */
public class Comsum extends Thread {
	private Buffer buf ;
	private Thread th ;
	
	public Comsum(Buffer buf , Thread th) {
		this.buf = buf ;
		this.th = th ;
	}
	
	//这里判断消费者线程退出的条件是，生产者线程还未死亡，可以理解为只要生产者未死亡
    //消费者就可以消费
    @Override
    public void run(){
        while(th.isAlive())
             buf.consume();
    }


}
