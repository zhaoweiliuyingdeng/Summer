package com.zw.consum;

import com.zw.buffer.Buffer;

/**
 * ��������
 * @author ��ޱ
 *
 */
public class Comsum extends Thread {
	private Buffer buf ;
	private Thread th ;
	
	public Comsum(Buffer buf , Thread th) {
		this.buf = buf ;
		this.th = th ;
	}
	
	//�����ж��������߳��˳��������ǣ��������̻߳�δ�������������ΪֻҪ������δ����
    //�����߾Ϳ�������
    @Override
    public void run(){
        while(th.isAlive())
             buf.consume();
    }


}
