//Name: Jin Qin
//ID: 20542346
//Input description: No user input required.
//Output description: Displays the found magic square, the number of attempts, start time, end time, and total execution time on the console.
//Summary: A program that randomly generates 3x3 matrices until it finds a magic square. A magic square contains all digits 1-9 exactly once, and all rows, columns, and diagonals sum to 15. The program measures and displays the time taken to find the solution.
//Declaration: I, Jin Qin hereby declare that the attached assignment has been completed and submitted as required by myself as an individual.
package magicSquare;

import java.util.Date;

public class MagicSquare {

	public static void main(String[] args) {
		
		long StartTime = System.currentTimeMillis();
		int[][] matrix = new int[3][3];
		int tries = 0;
		boolean found = false;
		
		while(!found) {
			tries++;
			generate(matrix);
			
			if(judgment(matrix)) {
				found = true;
			}
		}
		
		long EndTime = System.currentTimeMillis();
		double ElapsedSeconds = (EndTime - StartTime) / 1000.0;
		printResult(matrix, tries, StartTime, EndTime, ElapsedSeconds);
	}
	
	public static void generate(int[][] matrix) {
		
		int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for(int i = digits.length - 1; i > 0; i--) {
			int j = (int)(Math.random() * (i + 1));
			int temp = digits[i];
			digits[i] = digits[j];
			digits[j] = temp;
		}
		
		int index = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				matrix[i][j] = digits[index];
				index++;
			}
		}
	}
	
	public static boolean judgment(int[][] matrix) {
		
		boolean[] seen = new boolean[10];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				int value = matrix[i][j];
				if(value < 1|| value > 9) {
					return false;
				}
				if(seen[value]) {
					return false;
				}
				seen[value] = true;
			}
		}
		
		for(int i = 1; i <=9; i++) {
			if(!seen[i]){
				return false;
			}
		}
		
		int MagicSum = 15;
		
		for(int i = 0; i < 3; i++) {
			int sum = matrix[i][0] + matrix[i][1] + matrix[i][2];
			if(sum != MagicSum) {
				return false;
			}
		}
		
		for(int j = 0; j < 3; j++) {
			int sum = matrix[0][j] + matrix[1][j] + matrix[2][j];
			if(sum != MagicSum) {
				return false;
			}
		}
		
		int diag1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
		if(diag1 != MagicSum) {
			return false;
		}
		
		int diag2 = matrix[0][2] + matrix[1][1] + matrix[2][0];
		if(diag2 != MagicSum) {
			return false;
		}
		return true;
	}
	
	public static void printResult(int[][] matrix, int tries, long StartTime, long EndTime, double ElapsedSeconds) {
		
		String MatrixStr = "[";
		
		for(int i = 0; i < 3; i++) {
			MatrixStr += "[";
			for(int j = 0; j < 3; j++) {
				MatrixStr += matrix[i][j];
				if(j < 2) {
					MatrixStr += ",";
				}
			}
			
			MatrixStr += "]";
			if(i < 2) {
				MatrixStr += ",";
			}
		}
		
		MatrixStr +="]";
		double StartSeconds = StartTime / 1000.0;
		double EndSeconds = EndTime / 1000.0;
		
		System.out.println("1\n2\n3\n.\n.\n.\n" + (tries - 2) + "\n" + (tries - 1) + "\n" + tries);
		System.out.println("It is a magic square " + MatrixStr);
		System.out.println("It strated at: " + StartSeconds + " using seconds");
		System.out.println("It ended at: " + EndSeconds + " using seconds");
		Date StartDate = new Date(StartTime);
		Date EndDate = new Date(EndTime);
		System.out.println("It started at: " + StartDate);
		System.out.println("It ended at: " + EndDate);
		System.out.println("It took " + (int)ElapsedSeconds + " seconds to find the magic square");
	}
}




















