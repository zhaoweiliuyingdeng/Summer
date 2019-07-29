package com.zw.simple;

public class ConcreteColleague1 implements SimpleColleague {
   
	public  ConcreteColleague1(){
		
        SimpleMediator smd=SimpleMediator.getMedium();
        smd.register(this);
    }

    public void receive()
    {    System.out.println("具体同事类1：收到请求。");    }   
    public void send()
    {
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("具体同事类1：发出请求...");
        smd.relay(this); //请中介者转发
    }

}
