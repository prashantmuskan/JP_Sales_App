package com.sales.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sales.app.data.TestDataGenerator;
import com.sales.app.message.Message;
import com.sales.app.message.ProductType;
import com.sales.app.message.impl.Adjustment;
import com.sales.app.message.impl.ProcessedProduct;

public class SalesExecutor {

	public void execute(int messageCount) {
		Map<ProductType, List<ProcessedProduct>> processedProducts = new HashMap<>();
		Map<ProductType, List<Adjustment>> adjustmentsMap = new HashMap<>();

		for (int i = 1; i <= messageCount; i++) {
			recordMessage(processedProducts, adjustmentsMap);
			if (i % 10 == 0) {
				printProductTotalValue(processedProducts);
			}

			if (i % 50 == 0) {
				printProductAdjustments(adjustmentsMap);
			}
		}
	}

	private void recordMessage(Map<ProductType, List<ProcessedProduct>> processedProducts,
			Map<ProductType, List<Adjustment>> adjustmentsMap) {
		Message message = TestDataGenerator.generate();
		System.out.println("NEW MESSAGE : "+message);

		List<ProcessedProduct> productls = processedProducts.get(message.getProductType());
		if (null == productls) {
			productls = new ArrayList<>();
			processedProducts.put(message.getProductType(), productls);
		}
		
		ProcessedProduct pProduct = new ProcessedProduct();
		switch(message.getType()) {
		case SINGLE_SALE:
			processProduct(message, pProduct);
			productls.add(pProduct);
			break;
		case MULTI_SALE:
			for (int i = 0; i < message.getOccurances(); i++) {
				processProduct(message, pProduct);
				productls.add(pProduct);
			}
			break;
		case ADJUSTMENT:
			List<Adjustment> adjustments = adjustmentsMap.get(message.getProductType());
			if (null == adjustments) {
				adjustments = new ArrayList<>();
				adjustmentsMap.put(message.getProductType(), adjustments);
			}
			adjustments.add(processProductAdjustment(message, productls));
			break;
		default:
			break;
		 
		}
	}

	private void processProduct(Message message, ProcessedProduct pProduct) {
		pProduct.addSalesCount()
		  .addPrice(message.getPrice()) 
	      .setType(message.getProductType());
	}
	
	private Adjustment processProductAdjustment(Message message, List<ProcessedProduct> productls) {
		
		for (ProcessedProduct pProduct : productls) {
			pProduct.addAdjCount();

			switch (message.getOperation()) {
			case ADD:
				pProduct.addPrice(message.getAdjustment());
				break;
			case SUBSTRACT:
				pProduct.setPrice(pProduct.getPrice() - message.getAdjustment());
				break;
			case MULTIPLY:
				pProduct.setPrice(pProduct.getPrice() - message.getAdjustment());
				break;
			default:
				throw new RuntimeException("Operation not supported") ;
			}
		}
        
		return new Adjustment()
		  .setAdjustment(message.getAdjustment())
		  .setOperation(message.getOperation());
	}
	
	/**
	 * Print detailed report logging the number of sales of each product and their
	 * total value
	 * 
	 * @param messageList
	 */
	private void printProductTotalValue(Map<ProductType, List<ProcessedProduct>> processedProducts) {
		System.out.println("\n******************************");
		System.out.println("Print detailed report logging");
		System.out.println("ProductType, NoOfSales, TotalValue");

		for (ProductType type : processedProducts.keySet()) {
			int salesCount = 0;
			double totalValue = 0;
			for (ProcessedProduct pProduct : processedProducts.get(type)) {
				salesCount += pProduct.getSalesCount();
				totalValue += pProduct.getPrice();
			}
			System.out.println(type + ", " + salesCount + ", " + totalValue);
		}
		System.out.println("******************************\n");

	}

	/**
	 * Log a report of the adjustments that have been made to each sale type while
	 * the application was running
	 * 
	 * @param messageList
	 */
	private void printProductAdjustments(Map<ProductType, List<Adjustment>> adjustmentsMap) {
		System.out.println("\n\n APPLICATION IS PAUSING \n\n");
		System.out.println("\n******************************");
		System.out.println("Log a report of the adjustments that have been made");
		System.out.println("Count, ProductType, Operation, Adjustments");
		
		int count = 0;
		for (ProductType type : adjustmentsMap.keySet()) {
			for (Adjustment adj : adjustmentsMap.get(type)) {
				System.out.println(++count + ", " + type + ", " + adj.getOperation() + ", " + adj.getAdjustment());
			}
		}
		
		System.out.println("******************************\n");

	}

}
