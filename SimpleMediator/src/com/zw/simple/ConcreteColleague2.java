package com.zw.simple;

public class ConcreteColleague2 implements SimpleColleague {

   public ConcreteColleague2(){
        SimpleMediator smd=SimpleMediator.getMedium();
        smd.register(this);
    }
    public void receive()
    {    System.out.println("����ͬ����2���յ�����");    }   
    public void send()
    {
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("����ͬ����2����������...");
        smd.relay(this); //���н���ת��
    }

}
