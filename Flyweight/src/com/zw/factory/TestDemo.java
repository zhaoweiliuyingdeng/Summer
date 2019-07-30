package com.zw.factory;

import com.zw.flyweight.Flyweight;
import com.zw.flyweight.UnsharedFlyweight;

public class TestDemo {

	public static void main(String[] args) {
        FlyweightFactory factory=new FlyweightFactory();
        Flyweight f01=factory.getFlyweight("a");
        Flyweight f02=factory.getFlyweight("a");
        Flyweight f03=factory.getFlyweight("a");
        Flyweight f11=factory.getFlyweight("b");
        Flyweight f12=factory.getFlyweight("b");       
        f01.operation(new UnsharedFlyweight("��1�ε���a��"));       
        f02.operation(new UnsharedFlyweight("��2�ε���a��"));       
        f03.operation(new UnsharedFlyweight("��3�ε���a��"));       
        f11.operation(new UnsharedFlyweight("��1�ε���b��"));       
        f12.operation(new UnsharedFlyweight("��2�ε���b��"));

	}

}
