package com.zw.mediator;

import com.zw.colleague.Colleague;

public abstract class Mediator {
	public abstract void register(Colleague colleague) ;
	public abstract void relay(Colleague colleague) ;

}
