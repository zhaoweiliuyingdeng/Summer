package com.zw.kitchen;

import crabCooking.CrabCooking;

public class Kitchen {
	private CrabCooking crab ;

	public CrabCooking getCrab() {
		return crab;
	}

	public void setCrab(CrabCooking crab) {
		this.crab = crab;
	}
	public void CookMedthod() {
		crab.CookMedthod();
	}


}
