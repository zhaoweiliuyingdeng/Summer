package com.zw.flyweight;

public class ConcreteFlyweight1 implements Flyweight {
	private String key ;
	public ConcreteFlyweight1(String key) {
		this.key = key ;
		System.out.println("������Ԫ��ɫ"+key+"��������");
	}

	@Override
	public void operation(UnsharedFlyweight outState) {
		System.out.println("������Ԫ"+key+"������");
		System.out.println("�Ǿ�����Ԫ����Ϣ��"+outState.getInfo());

	}

}
