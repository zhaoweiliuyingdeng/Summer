package com.zw.simple;

import java.util.*;

public class SimpleMediator {
	private static SimpleMediator smd = new SimpleMediator() ;
	private List<SimpleColleague> colleagues = new ArrayList<SimpleColleague>() ;
	private SimpleMediator() {
		
	}
    public static SimpleMediator getMedium() {
    	return smd ;
    }
    
    public void register(SimpleColleague colleague)
    {
        if(!colleagues.contains(colleague))
        {
            colleagues.add(colleague);
        }
    }
    public void relay(SimpleColleague scl)
    {       
        for(SimpleColleague ob:colleagues)
        {
            if(!ob.equals(scl))
            {
                ((SimpleColleague)ob).receive();
            }   
        }
    }

}
