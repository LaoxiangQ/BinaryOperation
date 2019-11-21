package MyPackage;

import java.util.Random;

public class BinaryOperation_0 {
	static int [][] Exercise = new int[50][3];
//	int [] result = new int[50];
	
	public static void printHeader() {
		System.out.println("-------------------------------------");
		System.out.println("- 程序输出50道100以内的加减法算式的习题     -");
		System.out.println("- 每次运行程序可得到一套50道题的习题及答案  -");
		System.out.println("-------------------------------------");
	}
	public static boolean doubleCheck(int tag) {
		for(int i=0;i<tag;i++) {
			if(Exercise[i][0]==Exercise[tag][0] && Exercise[i][1]==Exercise[tag][1] 
					&& Exercise[i][2]==Exercise[tag][2])
				return false;
		}
		return true;
	}
	public static void generateEquations() {
		int count=0;
		while(count<50) {
			Random a = new Random();
			Random b = new Random();
			Random c = new Random();
			Exercise[count][0]=a.nextInt(101);
			Exercise[count][1]=b.nextInt(101);
			Exercise[count][2]=c.nextInt(2);
			if(!doubleCheck(count)) {
				continue;
			}
			if(Exercise[count][2]==1) {
				if((Exercise[count][0]+Exercise[count][1])>100)
					continue;
			} else {
				if((Exercise[count][0]-Exercise[count][1])<0)
					continue;
			}
			count++;
		}
	}
	public static void printExercise() {
		for(int i=0;i<50;i++) {
			if(Exercise[i][2]==1) {
				System.out.print((i+1)+" : "+Exercise[i][0]+"+"+Exercise[i][1]+"=\t");
			} else {
				System.out.print((i+1)+" : "+Exercise[i][0]+"-"+Exercise[i][1]+"=\t");
			}
			if((i+1)%5==0) {
				System.out.println();
			}
		}
	}
	public static void printCalculation() {
		System.out.println("-------------------------------------");
		System.out.println("- 以下是习题的参考答案 -");
		System.out.println("-------------------------------------");
		for(int i=0;i<50;i++) {
			if(Exercise[i][2]==1) {
				System.out.println((i+1)+" : \t"+(Exercise[i][0]+Exercise[i][1]));
			} else {
				System.out.println((i+1)+" : \t"+(Exercise[i][0]-Exercise[i][1]));
			}
		}
	}
	public static void main(String [] args) {
		printHeader();
		generateEquations();
		printExercise();
		printCalculation();
	}
}