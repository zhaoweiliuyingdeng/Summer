package com.zw.simple;

public class ConcreteColleague1 implements SimpleColleague {
   
	public  ConcreteColleague1(){
		
        SimpleMediator smd=SimpleMediator.getMedium();
        smd.register(this);
    }

    public void receive()
    {    System.out.println("����ͬ����1���յ�����");    }   
    public void send()
    {
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("����ͬ����1����������...");
        smd.relay(this); //���н���ת��
    }

}
