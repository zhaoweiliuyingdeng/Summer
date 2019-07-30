package com.zw.flyweight;

public class ConcreteFlyweight2 implements Flyweight {
	private String key ;
	public ConcreteFlyweight2(String key) {
		this.key = key ;
		System.out.println("具体享元角色"+key+"被创建了");
	}

	@Override
	public void operation(UnsharedFlyweight outState) {
		System.out.println("具体享元"+key+"被调用");
		System.out.println("非具体享元的信息是"+outState.getInfo());

	}

}
