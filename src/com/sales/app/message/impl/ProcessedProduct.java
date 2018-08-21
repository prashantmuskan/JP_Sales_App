package com.sales.app.message.impl;

import com.sales.app.message.ProductType;

public class ProcessedProduct {

	private ProductType type;
	private Double price = 0.0;
	private int salesCount = 0;
	private int adjCount = 0;

	public ProductType getType() {
		return type;
	}

	public ProcessedProduct setType(ProductType type) {
		this.type = type;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public ProcessedProduct setPrice(Double price) {
		this.price = price;
		return this;
	}

	public int getSalesCount() {
		return salesCount;
	}

	public ProcessedProduct setSalesCount(int salesCount) {
		this.salesCount = salesCount;
		return this;
	}

	public ProcessedProduct addSalesCount() {
		this.salesCount++;
		return this;
	}

	public int getAdjCount() {
		return adjCount;
	}

	public ProcessedProduct setAdjCount(int adjCount) {
		this.adjCount = adjCount;
		return this;
	}

	public ProcessedProduct addAdjCount() {
		this.adjCount++;
		return this;
	}

	public ProcessedProduct addPrice(double value) {
		setPrice(getPrice() + value);
		return this;
	}

}
