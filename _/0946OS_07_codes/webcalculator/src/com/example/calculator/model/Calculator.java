package com.example.calculator.model;

public class Calculator {
	private double op1, op2;
	private String operation;
	
	public Calculator(String op1, String op2, String operation) {
		try {
			this.op1 = Double.parseDouble(op1);
			this.op2 = Double.parseDouble(op2);
			this.operation = operation;
		}
		catch (NumberFormatException e) {
			//reset the value of both operands
			this.op1 = 0.0;
			this.op2 = 0.0;
		}
	}
	
	public double performCalculation() {
		if (operation.equals("+")) {
			return op1 + op2;
		} else if (operation.equals("-")) {
			return op1 - op2;
		} else if (operation.equals("/")) {
			return op1 / op2;
		} else if (operation.equals("*")) {
			return op1 * op2;
		}
		return 0;		
	}

}
