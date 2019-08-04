package com.zw.context;

import com.zw.strategy.*;

public class TestDemo {

	public static void main(String[] args) {
		Strategy strategyA  = new ConcreteStrategyA() ;
		Strategy strategyB = new ConcreteStrategyB() ;
		Context con1 = new Context() ;
		con1.setStrategy(strategyA);
		Context con2 = new Context() ;
		con1.strategyMedthod();
		con2.setStrategy(strategyB);
		con2.strategyMedthod();

	}
	

}
