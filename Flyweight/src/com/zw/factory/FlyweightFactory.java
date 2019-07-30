package com.zw.factory;

import java.util.HashMap;

import com.zw.flyweight.ConcreteFlyweight1;
import com.zw.flyweight.Flyweight;

public class FlyweightFactory {
	private HashMap<String , Flyweight> flyweights = new HashMap<String , Flyweight>() ;
	public Flyweight getFlyweight(String key) {
       
		Flyweight flyweight=(Flyweight)flyweights.get(key);
       
        if(flyweight!=null)
        {
            System.out.println("具体享元"+key+"已经存在，被成功获取！");
        }
        else
        {
            flyweight=new ConcreteFlyweight1(key);
            flyweights.put(key, flyweight);
        }
        return flyweight; 
	}

}
