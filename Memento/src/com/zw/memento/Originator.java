package com.zw.memento;

public class Originator {
	private String state ;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public Memento createMmento() {
		return new Memento(state) ;
	}
	public void restoreMemento(Memento m) {
		this.setState(m.getState());
	}

}
