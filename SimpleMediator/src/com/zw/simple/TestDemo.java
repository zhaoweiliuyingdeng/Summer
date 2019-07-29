package com.zw.simple;

public class TestDemo {
    public static void main(String[] args)
    {
        SimpleColleague c1,c2;
        c1=new ConcreteColleague1();
        c2=new ConcreteColleague2();
        c1.send();
        System.out.println("-----------------");
        c2.send();
    }

}
