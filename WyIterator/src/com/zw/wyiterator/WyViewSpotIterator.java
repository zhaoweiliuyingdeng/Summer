package com.zw.wyiterator;

import java.util.ArrayList;

import com.zw.pojo.WyViewSpot;

public class WyViewSpotIterator implements ViewSpotIterator {

    private ArrayList<WyViewSpot> list=null; 
    private int index =-1;
    WyViewSpot obj=null;
    public WyViewSpotIterator(ArrayList<WyViewSpot> list)
    {
        this.list=list; 
    } 
   
	@Override
	public WyViewSpot first() {
		index = 0 ;
	    obj = list.get(index) ;
		return obj ;
	}
	@Override
	public WyViewSpot next() {
		if(this.hasNext())
		{
			index = 0 ;
			obj = list.get(++index) ;
		}
			return obj ;
	}
	@Override
	public WyViewSpot previous() {
		if(index>0)
        { 
            obj=list.get(--index); 
        } 
        return obj; 
	}
	@Override
	public WyViewSpot last() {
        index=list.size()-1;
        obj=list.get(index);
        return obj;
	}

	@Override
	public boolean hasNext() {
		if(index < list.size() -1) {
			return true ;
		}else {
			return false ;
		}
	}

}
