package com.sales.app.message.impl;

import com.sales.app.message.Message;
import com.sales.app.message.MessageType;
import com.sales.app.message.Operations;
import com.sales.app.message.ProductType;

public class MessageImpl implements Message {

	private MessageType type;
	private ProductType productType;
    private double price = 0.0;
	private Operations operation;
	private int adjustment = 0;
	private int occurances = 0;

	public MessageImpl() {
	}

	public MessageType getType() {
		return type;
	}

	public MessageImpl setType(MessageType type) {
		this.type = type;
		return this;
	}

	public ProductType getProductType() {
		return productType;
	}

	public MessageImpl setProductType(ProductType product) {
		this.productType = product;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public MessageImpl setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Operations getOperation() {
		return operation;
	}

	public MessageImpl setOperation(Operations operation) {
		this.operation = operation;
		return this;
	}

	public Integer getAdjustment() {
		return adjustment;
	}

	public MessageImpl setAdjustment(Integer adjustment) {
		this.adjustment = adjustment;
		return this;
	}

	public Integer getOccurances() {
		return occurances;
	}

	public MessageImpl setOccurances(Integer occurances) {
		this.occurances = occurances;
		return this;
	}

	@Override
	public String toString() {
		return "MessageImpl [type=" + type + ", productType=" + productType + ", price=" + price + ", operation=" + operation + ", adjustment="
				+ adjustment + ", occurances=" + occurances + "]";
	}

	
}