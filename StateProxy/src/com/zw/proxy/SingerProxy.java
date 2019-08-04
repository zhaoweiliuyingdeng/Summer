package com.zw.proxy;
/**
 * 代理对象和目标对象实现相同的接口
 * @author 赵薇
 *
 */
public class SingerProxy implements ISinger {
	//接收目标对象，以便调用方法
	private ISinger singer ;
	
	public SingerProxy(ISinger singer) {
		super();
		this.singer = singer;
	}


	/**
	 * 对目标对象的sing方法进行扩展
	 */
	@Override
	public void sing() {
		System.out.println("向观众问好。");
		singer.sing();
		System.out.println("谢谢大家。");

	}

}
