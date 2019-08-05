package com.zw.aggregate;

import java.util.ArrayList;

import com.zw.pojo.WyViewSpot;
import com.zw.wyiterator.ViewSpotIterator;
import com.zw.wyiterator.WyViewSpotIterator;

public class WyViewSpotSet implements ViewSpotSet {
	private ArrayList<WyViewSpot> list=new ArrayList<WyViewSpot>(); 

	@Override
	public void add(WyViewSpot obj) {
		list.add(obj) ;

	}

	@Override
	public void remove(WyViewSpot obj) {
		list.remove(obj) ;

	}

	@Override
	public ViewSpotIterator getIterator() {
		
		return (new WyViewSpotIterator(list));
	}

}
