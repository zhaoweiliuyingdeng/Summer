package com.zw.buffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * ��������
 * @author ��ޱ
 *
 */
public class Buffer {
	//��ȡ���ݵĻ�����
	private volatile byte[] bytes = new byte[1024] ;
	
	//�źŵƷ����жϸ��߳���������������
	private boolean flag = false ;
	
	//��ȡ���ֽ�������Ϊ�����������Ϊ�Ƕ�ȡ�ļ������ݣ�����ÿ�ζ�ȡ��ʱ�򣬶����ϴζ���λ�ÿ�ʼ
	private int pos = 0 ; 
	
	/**
	 * �źŵƷ��ĺ��ģ�
	 * ���flagΪ�棬��ô���������ѡ������ߵȴ�
	 * ���flagΪ�٣���ô�����������������ߵȴ�
	 * �̵߳ĵȴ���wait��������notify
	 */
	//������Ϊ
	public synchronized int product(File file) {
		if(flag) {
			try {
				//flagΪ�棬�����ߵȴ�
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//flagΪ�٣�������������Ҳ���Ƕ�ȡ�ļ������ݵ�������
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��ȡ���ݵ�������������ÿ�ζ�ȡ���ֽ���
			pos = read(file) ;
			
			//������Ϻ��������ڴεȴ�
			flag = true ;
			//����������������
			this.notify();

			//����ÿ�ζ�ȡ���ֽ����������ȡ���ļ���ĩβ������-1 ��
			//��Ҳ����Ϊ������ֹͣ������
		return pos ;
	}

	//������Ϊ
	public synchronized void consume() {
		if(!flag) {
			//flagΪ�٣������ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//flagΪ�棬����������
		try {
			//ÿ����������1000ms
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ѣ����Ǵӻ������ȡ���ݣ����������̨
		prints() ;
		
		//�������ٴεȴ�
		flag = false ;
		
		//����������
		this.notify();
		
	}
	/**
	 * ���������ÿ�ζ�ȡ��󣬽�������Ϊ��
	 * ���ϵ�д��Ͷ�ȡ����
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

	//��ȡ���ݵķ���
	private int read(File file) {
		//����RandomAccessFile����Զ�λ���ϴζ�ȡ�ļ���λ��
		
		try {
			RandomAccessFile rf = new RandomAccessFile(file,"r") ;
			
			//���������ļ�ָ���λ�ã�ÿ�����ͻ�Ӵ�λ�ÿ�ʼ��ȡ
				rf.seek(pos);
				pos = rf.read(bytes) ;
			//���ָ��Ϊ-1 �� �������ļ�ĩβ��ֱ�ӷ���
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
		//�����ļ�ָ��
		return pos;
	}

}
