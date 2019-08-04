package com.zw.proxy;
/**
 * ��������Ŀ�����ʵ����ͬ�Ľӿ�
 * @author ��ޱ
 *
 */
public class SingerProxy implements ISinger {
	//����Ŀ������Ա���÷���
	private ISinger singer ;
	
	public SingerProxy(ISinger singer) {
		super();
		this.singer = singer;
	}


	/**
	 * ��Ŀ������sing����������չ
	 */
	@Override
	public void sing() {
		System.out.println("������ʺá�");
		singer.sing();
		System.out.println("лл��ҡ�");

	}

}
