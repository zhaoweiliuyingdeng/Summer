package com.zw.aggregate;

import java.util.* ;

import com.zw.iterator.ConcreteIterator;
import com.zw.iterator.Iterator;

public class ConcreteAggregate implements Aggregate {
	private List<Object> list = new ArrayList<Object>() ;

	@Override
	public void add(Object obj) {
		list.add(obj) ;

	}

	@Override
	public void remove(Object obj) {
		list.remove(obj) ;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return (new ConcreteIterator(list));
	}

}
