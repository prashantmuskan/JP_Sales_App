package com.sales.app.message;

public enum MessageType {
    SINGLE_SALE(0),
    MULTI_SALE(1),
    ADJUSTMENT(2);
	
	int type;
	private MessageType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public static MessageType get(int type) {
		for (MessageType mType : values() ) {
			if(mType.getType() == type )
				return mType;
		}
		return null;
	}
}
