package com.sales.app.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sales.app.message.Message;
import com.sales.app.message.MessageType;
import com.sales.app.message.Operations;
import com.sales.app.message.ProductType;
import com.sales.app.message.impl.MessageImpl;

public class TestDataGenerator {

	private static Random random = new Random();
	
    public static synchronized Message generate() {

    	Message message;
		int messageType = Math.abs(random.nextInt() % 3);
		ProductType productType = ProductType.get(Math.abs(random.nextInt() % 6));
		
		switch (messageType) {
			case 0:
				message = generateData(MessageType.SINGLE_SALE, productType);
				break;
			case 1:
				message = generateTypeTwoData(MessageType.MULTI_SALE, productType, 20);
				break;
			case 2:
				Operations ops = Operations.get(Math.abs(random.nextInt() % 3));
				message = generateTypeThreeData(MessageType.ADJUSTMENT, productType, ops, Math.abs(random.nextInt(20)));
				break;
			default:
				throw new RuntimeException("ERROR in random generator");
		}
		
		return message;
    }
    
    private static MessageImpl generateData(MessageType mtype, ProductType ptype) {
    	return new MessageImpl()
    			.setType(mtype)
    			.setProductType(ptype)
    			.setPrice(Math.abs(random.nextDouble()))
    			.setOperation(Operations.NONE)
    			.setAdjustment(0)
    			.setOccurances(0);
	}
    
    private static MessageImpl generateTypeTwoData(
    		MessageType mtype, 
    		ProductType ptype, 
    		Integer occurances) {
    	return generateData(mtype, ptype).setOccurances(occurances);
	}
    
    private static MessageImpl generateTypeThreeData(
    		MessageType mtype, 
    		ProductType ptype, 
    		Operations ops,
    		Integer adjustment) {
    	
    	return generateData(mtype, ptype)
    			.setOperation(ops)
    			.setAdjustment(adjustment);
	}

}
