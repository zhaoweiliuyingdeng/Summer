package com.zw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理
 * @author 赵薇
 *
 */
public class TestDemo {

	public static void main(String[] args) {
		Singer singer = new Singer() ;
		ISinger proxy = (ISinger)Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("向观众问好。");
				//执行目标对象方法
				Object returnValue = method.invoke(singer, args);
				System.out.println("谢谢大家。");
				return returnValue;
			}
			
		}) ;
		proxy.sing();

	}

}
