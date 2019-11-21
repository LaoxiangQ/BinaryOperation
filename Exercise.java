package Mypackage;

import java.util.ArrayList;
import java.util.Random;

public class Exercise {
	private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();
	private int current = 0;
	
	public void generateBinaryExercise(int operationCount) {
		BinaryOperation anOperation;
		while(operationCount > 0) {
			do {
				anOperation = generateOperation();
			} while(contains(anOperation));
			operationList.add(anOperation);
			operationCount--;
		}
	}
	
	public void generateAdditionExercise(int operationCount) {
		BinaryOperation anOperation;
		while(operationCount > 0) {
			do {
				anOperation = new AdditionOperation();
			} while(contains(anOperation));
			operationList.add(anOperation);
			operationCount--;
		}
	}
	
	public void generateSubstractExercise(int operationCount) {
		BinaryOperation anOperation;
		while(operationCount > 0) {
			do {
				anOperation = new SubstractOperation();
			} while(contains(anOperation));
			operationList.add(anOperation);
			operationCount--;
		}
	}
	
	public boolean contains(BinaryOperation anOperation) {
		boolean flag = true;
		int size = operationList.size();
		if(size == 0) {
			return false;
		}
		for(int i = 0; i < size; i++) {
			if(!operationList.get(i).equals(anOperation)) {
				flag = false;
			}
		}
		return flag;
	}
	
	private BinaryOperation generateOperation() {
		Random random = new Random();
		int opValue = random.nextInt(2);
		if (opValue == 1) {
			return new AdditionOperation();
		}
		return new SubstractOperation();
	}
	
	public boolean hasnext(int current) {
		return current <= operationList.size()-1;
	}
	
	public BinaryOperation next(int current) {
		return operationList.get(current);
	}
}