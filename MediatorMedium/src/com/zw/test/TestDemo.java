package com.zw.test;

import com.zw.customer.*;
import com.zw.medium.*;

public class TestDemo {

	public static void main(String[] args) {
        Medium md=new EstateMedium();    //�����н�
        Customer member1,member2;
        member1=new Seller("����(����)");
        member2=new Buyer("����(��)");
        md.register(member1); //�ͻ�ע��
        md.register(member2);

	}

}
