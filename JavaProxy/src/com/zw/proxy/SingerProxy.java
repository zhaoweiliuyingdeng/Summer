package com.zw.proxy;
/**
 * ��̬������������Ŀ�����ʵ����ͬһ���ӿڡ�
 * ������������ǰд����
 * �ӿڲ㷢���仯���������Ĵ���ҲҪ��Ӧ����
 * @author ��ޱ
 *
 */
public class SingerProxy implements Interface{
	private Interface target ;
	public SingerProxy(Interface target) {
		this.target = target ;
	}

	@Override
	public void sing() {
		System.out.println("��Һá�������");
		target.sing();
		System.out.println("лл��ҡ�������");
		
	}
	public static void main(String[] args) {
		Interface target = new Singer() ;
		SingerProxy p = new SingerProxy(target) ;
		p.sing();
	}

}
