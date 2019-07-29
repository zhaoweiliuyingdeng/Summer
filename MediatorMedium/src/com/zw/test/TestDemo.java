package com.zw.test;

import com.zw.customer.*;
import com.zw.medium.*;

public class TestDemo {

	public static void main(String[] args) {
        Medium md=new EstateMedium();    //房产中介
        Customer member1,member2;
        member1=new Seller("张三(卖方)");
        member2=new Buyer("李四(买方)");
        md.register(member1); //客户注册
        md.register(member2);

	}

}
