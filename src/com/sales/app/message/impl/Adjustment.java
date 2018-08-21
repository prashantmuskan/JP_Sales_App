package com.sales.app.message.impl;

import com.sales.app.message.Operations;

public class Adjustment {

	private Operations operation;
	private int adjustment = 0;
	
	public Operations getOperation() {
		return operation;
	}

	public Adjustment setOperation(Operations operation) {
		this.operation = operation;
		return this;
	}

	public Integer getAdjustment() {
		return adjustment;
	}

	public Adjustment setAdjustment(Integer adjustment) {
		this.adjustment = adjustment;
		return this;
	}

}
