package Mypackage;

import java.util.Random;

public abstract class BinaryOperation {
	static final int UPPER = 100;
	static final int LOWER = 0;
	private int left_operand = 0, right_operand = 0;
	private char operator = '+';
	private int value = 0;
	
	protected void generateBinaryOperation(char anOperator) {
		int left, right, result;
		Random random = new Random();
		left = random.nextInt(UPPER+1);
		do {
			right = random.nextInt(UPPER+1);
			result = calculate(left, right);
		} while (!(checkingCalculation(result)));
		left_operand = left;
		right_operand = right;
		operator = anOperator;
		value = result;
	}
	
	abstract boolean checkingCalculation(int anInteger);
	abstract int calculate(int left, int right);
	
	public int getLeftOperand() {
		return left_operand;
	}
	public int getRightOperand() {
		return right_operand;
	}
	public char getOperator() {
		return operator;
	}
	public int getValue() {
		return value;
	}
	
	public boolean equals(BinaryOperation anOperation) {
		return left_operand == anOperation.getLeftOperand() & 
				right_operand == anOperation.getRightOperand() &
				operator == anOperation.getOperator();
	}
}

class AdditionOperation extends BinaryOperation {
	AdditionOperation(){
		generateBinaryOperation('+');
	}
	public boolean checkingCalculation(int anInteger) {
		return (anInteger <= UPPER);
	}
	int calculate(int left, int right) {
		return left+right;
	}
}

class SubstractOperation extends BinaryOperation {
	SubstractOperation(){
		generateBinaryOperation('-');
	}
	public boolean checkingCalculation(int anInteger) {
		return (anInteger <= UPPER && anInteger >= 0);
	}
	int calculate(int left, int right) {
		return left-right;
	}
}