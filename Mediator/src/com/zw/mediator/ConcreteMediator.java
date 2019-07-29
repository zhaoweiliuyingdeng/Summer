package com.zw.mediator;

import java.util.ArrayList;
import java.util.List;

import com.zw.colleague.Colleague;

public class ConcreteMediator extends Mediator {
	private List<Colleague> colleagues = new ArrayList<Colleague>() ;

	@Override
	public void register(Colleague colleague) {
		if(!colleagues.contains(colleague)) {
			colleagues.add(colleague) ;
			colleague.setMedium(this);
		}
	}

	@Override
	public void relay(Colleague colleague) {
		for (Colleague coll : colleagues) {
			if(coll.equals(colleague)) {
				coll.receive();
			}
		}
	}

}
