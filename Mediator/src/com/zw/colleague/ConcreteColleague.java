package com.zw.colleague;

public class ConcreteColleague extends Colleague {

	@Override
	public void receive() {
		System.out.println("�յ�����ͬ����1������");

	}

	@Override
	public void send() {
		System.out.println("����ͬ����1��������");
		mediator.relay(this);

	}

}
