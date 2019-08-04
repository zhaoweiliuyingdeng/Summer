package com.zw.proxy;
/**
 * 目标对象实现某一接口
 * @author 赵薇
 *
 */
public class Singer implements ISinger {

	@Override
	public void sing() {
		System.out.println("唱一首歌");

	}

}
