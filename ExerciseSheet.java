package Mypackage;

public class ExerciseSheet {
	private static final short 	COLUMN_NUMBER = 5;
	public void formattedDisplay (Exercise ex, int columns) {
		int col = columns;
		int num = 0;
		while(ex.hasnext(num)) {
			col--;
			BinaryOperation bop;
			bop = ex.next(num++);
			System.out.print(num + ". " + bop.getLeftOperand() + bop.getOperator() + bop.getRightOperand() + "= \t");
			if(col == 0) {
				System.out.println("");
				col = columns;
			}
		}
		System.out.println("");
	}
	
	public void resultDisplay (Exercise ex, int columns) {
		System.out.println("\n---- 以下是习题的参考答案 ----\n");
		int col = columns;
		int num = 0;
		while(ex.hasnext(num)) {
			col--;
			BinaryOperation bop;
			bop = ex.next(num++);
			System.out.print(num + ". " + bop.getLeftOperand() + bop.getOperator() + bop.getRightOperand() + "=" + bop.getValue()+"\t");
			if(col == 0) {
				System.out.println("");
				col = columns;
			}
		}
	}
	
	public static void main(String [] args) {
		ExerciseSheet sheet1 = new ExerciseSheet();
		Exercise exercise1 = new Exercise();
		exercise1.generateBinaryExercise(50);
		System.out.println("\n---- 程序输出50道100以内的加减法算式的习题 ----\n");
		sheet1.formattedDisplay(exercise1, 5);
		sheet1.resultDisplay(exercise1, 5);
		
		ExerciseSheet sheet2 = new ExerciseSheet();
		Exercise exercise2 = new Exercise();
		exercise2.generateSubstractExercise(50);
		System.out.println("\n---- 程序输出50道100以内的减法算式的习题 ----\n");
		sheet2.formattedDisplay(exercise2, 5);
		sheet2.resultDisplay(exercise2, 5);
		
		ExerciseSheet sheet3 = new ExerciseSheet();
		Exercise exercise3 = new Exercise();
		exercise3.generateAdditionExercise(50);
		System.out.println("\n---- 程序输出50道100以内的加法算式的习题 ----\n");
		sheet3.formattedDisplay(exercise3, 5);
		sheet3.resultDisplay(exercise3, 5);
	}
}