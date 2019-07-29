package com.zw.medium;

import com.zw.customer.Customer;

public interface Medium {
	public void register(Customer customer) ;
	public void relay(String from , String ad) ;

}
