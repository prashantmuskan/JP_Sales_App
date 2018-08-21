package com.sales.app.message;

public interface Message {

	MessageType getType();
	Message setType(MessageType type);

	ProductType getProductType();
    Message setProductType(ProductType products);

    Double getPrice();
    Message setPrice(Double price);
    
    Operations getOperation();
    Message setOperation(Operations op);
    
    Integer getAdjustment();
    Message setAdjustment(Integer adjustment);

    Integer getOccurances();
    Message setOccurances(Integer occurances);
}
