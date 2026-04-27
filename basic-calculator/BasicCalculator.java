//Name: Jin Qin
//ID: 20542346
//Input description: Users input numbers and operators via the keyboard.
//Output description: DIsplays calculation results or error messages on the console.
//Summary: A simple calculator that supports addition, subtraction, multiplication, division, exponentiation, and square root operations.
//Declaration: I confirm that this submission is my own work and is consistent with thw Queen's regulations on Academic Integrity.
package basiccalculator;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			//Enter the first number or exit command
			System.out.println("Enter the first number \n or '0' to quit: ");
			String xString = sc.nextLine();
			//If enter '0', the loop will exit
			if (xString.equals("0")) {
				break;
			}
			//Enter the operator
			System.out.println("Enter operation: ");
			String oper = sc.nextLine();
			//For the operators need the second number, read the second number
			String yString = null;
			if (oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/") || oper.equals("e")) {
				System.out.println("Enter the second number:");
				yString = sc.nextLine();
			}
			
			//Change the input into integer
			int x = Integer.parseInt(xString);
			int y = 0;
			if (yString != null) {
				y = Integer.parseInt(yString); 
			}
			
			//According to the operator, perform the calculation
			if (oper.equals("+")) {
				System.out.println(x + y + "\n");
			} else if (oper.equals("-")) {
				System.out.println(x - y + "\n");
			} else if (oper.equals("*")) {
				System.out.println(x * y + "\n");
			} else if (oper.equals("/")) {
				System.out.println(x / y + "\n");
			} else if (oper.equals("e")) {
				//Exponentiation (only supports non-negative integer exponents)
				if (y >= 0) {
					int i=0;
					int exp=1;
					while (i < y) {
						exp  = exp * x;
						i++;
					}
					System.out.println(exp + "\n");
				} else {
					System.out.println("error: negative square root\n");
				}
			} else if (oper.equals("s")) {
				//Square root operation (positive numbers only)
				if (x > 0) {
					System.out.println(Math.sqrt(x) + "\n");
				} else {
					System.out.println("error: negative squre root\n");
				}
			} else {
				//Invalid operators
				System.out.println("error: unknown operation\n");
			}
		}
		sc.close();
	}
}
