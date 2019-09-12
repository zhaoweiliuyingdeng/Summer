package com.zw.proxy;
/**
 * 静态代理。代理对象和目标对象实现了同一个接口。
 * 代理对象必须提前写出。
 * 接口层发生变化，代理对象的代码也要相应调整
 * @author 赵薇
 *
 */
public class SingerProxy implements Interface{
	private Interface target ;
	public SingerProxy(Interface target) {
		this.target = target ;
	}

	@Override
	public void sing() {
		System.out.println("大家好。。。。");
		target.sing();
		System.out.println("谢谢大家。。。。");
		
	}
	public static void main(String[] args) {
		Interface target = new Singer() ;
		SingerProxy p = new SingerProxy(target) ;
		p.sing();
	}

}
