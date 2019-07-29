package com.zw.colleague;

import com.zw.mediator.ConcreteMediator;
import com.zw.mediator.Mediator;

public class TestDemo {
	public static void main(String[] args) {
		Mediator md = new ConcreteMediator() ;
		Colleague cl = new ConcreteColleague() ;
		md.register(cl);
		cl.send();
	}

}
