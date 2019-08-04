package com.zw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * ��̬����
 * @author ��ޱ
 *
 */
public class TestDemo {

	public static void main(String[] args) {
		Singer singer = new Singer() ;
		ISinger proxy = (ISinger)Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("������ʺá�");
				//ִ��Ŀ����󷽷�
				Object returnValue = method.invoke(singer, args);
				System.out.println("лл��ҡ�");
				return returnValue;
			}
			
		}) ;
		proxy.sing();

	}

}
