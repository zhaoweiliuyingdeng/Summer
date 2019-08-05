package com.zw.aggregate;

import com.zw.pojo.WyViewSpot;
import com.zw.wyiterator.ViewSpotIterator;

public interface ViewSpotSet {
    public void add(WyViewSpot obj); 
    public void remove(WyViewSpot obj); 
    public ViewSpotIterator getIterator(); 

}
