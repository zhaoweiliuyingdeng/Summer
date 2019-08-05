package com.zw.wyiterator;

import com.zw.pojo.WyViewSpot;

public interface ViewSpotIterator {
	public boolean hasNext() ;
	public WyViewSpot first() ;
    public WyViewSpot next();
    public WyViewSpot previous();
    public WyViewSpot last(); 
	

}
