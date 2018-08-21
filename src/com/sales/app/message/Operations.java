package com.sales.app.message;

public enum Operations {
	NONE(-1), ADD(0), SUBSTRACT(1), MULTIPLY(2);
	
	int type;
	private Operations(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public static Operations get(int type) {
		for (Operations ptype : values() ) {
			if(ptype.getType() == type )
				return ptype;
		}
		return null;
	}
}
