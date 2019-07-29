package com.zw.medium;

import java.util.ArrayList;
import java.util.List;

import com.zw.customer.Customer;

public class EstateMedium implements Medium {
	private List<Customer> members = new ArrayList<Customer>() ; 

	@Override
	public void register(Customer customer) {
		if(!members.contains(customer)) {
			members.add(customer) ;
			
		}
	}

	@Override
	public void relay(String from, String ad) {
		// TODO Auto-generated method stub

	}

}
