package com.zw.context;

import com.zw.strategy.Strategy;

public class Context {
	private Strategy strategy ;

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void strategyMedthod() {
		strategy.strategyMethod();
	}

}
