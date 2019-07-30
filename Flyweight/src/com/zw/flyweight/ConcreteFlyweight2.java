package com.zw.flyweight;

public class ConcreteFlyweight2 implements Flyweight {
	private String key ;
	public ConcreteFlyweight2(String key) {
		this.key = key ;
		System.out.println("������Ԫ��ɫ"+key+"��������");
	}

	@Override
	public void operation(UnsharedFlyweight outState) {
		System.out.println("������Ԫ"+key+"������");
		System.out.println("�Ǿ�����Ԫ����Ϣ��"+outState.getInfo());

	}

}
