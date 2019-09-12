package com.zw.proxy2;
/**
 * ��̬����JDK������
 * Ŀ�����ͬ��Ҫʵ��һ���ӿ�
 * �������ڶ�̬�����ɴ������
 * 
    ClassLoader loader��ָ����ǰĿ�����ʹ�����������д���̶�
    Class<?>[] interfaces��Ŀ�����ʵ�ֵĽӿڵ����ͣ�д���̶�
    InvocationHandler h���¼�����ӿڣ��贫��һ��ʵ���࣬һ��ֱ��ʹ�������ڲ���

 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ISinger implements Target {

	@Override
	public void sing() {
		System.out.println("��һ�׸衢������");
	}
	public static void main(String[] args) {
		ISinger singer = new ISinger() ;
		Target proxy =(Target) Proxy.newProxyInstance(singer.getClass().getClassLoader(), 
				singer.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("��Һá�������");
						//ִ��Ŀ�귽��
						Object returnValue = method.invoke(singer, args) ;
						System.out.println("лл��ҡ�������");
						return returnValue;
					}
		});
		proxy.sing();
	}

}
