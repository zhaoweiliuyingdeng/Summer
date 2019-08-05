package com.zw.aggregate;

import com.zw.iterator.Iterator;

public interface Aggregate {
	public void add(Object obj ) ;
	public void remove(Object obj) ;
	public Iterator getIterator() ;

}
