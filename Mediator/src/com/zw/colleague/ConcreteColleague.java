package com.zw.colleague;

public class ConcreteColleague extends Colleague {

	@Override
	public void receive() {
		System.out.println("收到具体同事类1的请求");

	}

	@Override
	public void send() {
		System.out.println("具体同事类1发出请求");
		mediator.relay(this);

	}

}
