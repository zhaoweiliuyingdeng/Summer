package com.zw.memento;

public class Test {

	public static void main(String[] args) {
        Originator or=new Originator();
        CareTaker cr=new CareTaker();       
        or.setState("S0"); 
        System.out.println("��ʼ״̬:"+or.getState());           
        cr.setMemento(or.createMmento()); //����״̬      
        or.setState("S1"); 
        System.out.println("�µ�״̬:"+or.getState());        
        or.restoreMemento(cr.getMemento()); //�ָ�״̬
        System.out.println("�ָ�״̬:"+or.getState());

	}

}
