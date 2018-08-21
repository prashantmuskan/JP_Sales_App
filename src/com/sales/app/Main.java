package com.sales.app;

public class Main {

	public static void main(String[] args) {
		int messageCount = Integer.valueOf(System.getProperty("messages", "1000"));
		SalesExecutor execute = new SalesExecutor();
		execute.execute(messageCount);
	}

}
