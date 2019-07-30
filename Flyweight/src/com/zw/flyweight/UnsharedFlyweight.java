package com.zw.flyweight;

public class UnsharedFlyweight {
	private String info ;
	public UnsharedFlyweight(String info) {
		this.info = info ;
	}
	public void setInfo(String info) {
		this.info = info ;
	}
	public String getInfo() {
		return info ;
	}

}
