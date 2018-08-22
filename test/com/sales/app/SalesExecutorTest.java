package com.sales.app;

public class SalesExecutorTest {

	public static void testExecute(int messageCount) {
		SalesExecutor execute = new SalesExecutor();
		execute.execute(messageCount);
	}

	public static void main(String[] args) {
		SalesExecutorTest.testExecute(5000);
	}
}
