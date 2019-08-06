package com.zw.memento;

public class Test {

	public static void main(String[] args) {
        Originator or=new Originator();
        CareTaker cr=new CareTaker();       
        or.setState("S0"); 
        System.out.println("³õÊ¼×´Ì¬:"+or.getState());           
        cr.setMemento(or.createMmento()); //±£´æ×´Ì¬      
        or.setState("S1"); 
        System.out.println("ÐÂµÄ×´Ì¬:"+or.getState());        
        or.restoreMemento(cr.getMemento()); //»Ö¸´×´Ì¬
        System.out.println("»Ö¸´×´Ì¬:"+or.getState());

	}

}
