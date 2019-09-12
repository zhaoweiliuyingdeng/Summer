package com.zw.proxy2;
/**
 * 动态代理（JDK代理）：
 * 目标对象同样要实现一个接口
 * 在运行期动态的生成代理对象
 * 
    ClassLoader loader：指定当前目标对象使用类加载器，写法固定
    Class<?>[] interfaces：目标对象实现的接口的类型，写法固定
    InvocationHandler h：事件处理接口，需传入一个实现类，一般直接使用匿名内部类

 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ISinger implements Target {

	@Override
	public void sing() {
		System.out.println("唱一首歌、、、、");
	}
	public static void main(String[] args) {
		ISinger singer = new ISinger() ;
		Target proxy =(Target) Proxy.newProxyInstance(singer.getClass().getClassLoader(), 
				singer.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("大家好。。。。");
						//执行目标方法
						Object returnValue = method.invoke(singer, args) ;
						System.out.println("谢谢大家。。。。");
						return returnValue;
					}
		});
		proxy.sing();
	}

}
