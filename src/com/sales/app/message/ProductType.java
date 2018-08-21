package com.sales.app.message;

public enum ProductType {
    //STOCK(0), FORWARD(1), FUTURE(2), SWAP(3);
	
	APPLE(0), IBM(1), JPMC(2), GOOGLE(3), GE(4) ,SAMSUNG(5);
	
	int type;
	private ProductType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public static ProductType get(int type) {
		for (ProductType ptype : values() ) {
			if(ptype.getType() == type )
				return ptype;
		}
		return null;
	}
}
