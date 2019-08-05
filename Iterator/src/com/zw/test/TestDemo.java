package com.zw.test;

import com.zw.aggregate.* ;
import com.zw.iterator.Iterator;

public class TestDemo {

	public static void main(String[] args) {
		Aggregate ag = new ConcreteAggregate() ;
		ag.add("��ɽ��ѧ");
		ag.add("������");
		ag.add("�ع�ѧԺ");
		System.out.println("�ۺϵ������У�");
		Iterator it = ag.getIterator() ;
		while(it.hasNext()) {
			Object obj = it.next() ;
			System.out.println(obj.toString()+"\t");
		}
		Object ob = it.first() ;
		System.out.println("\nFirst:"+ob.toString());
		
	}

}
