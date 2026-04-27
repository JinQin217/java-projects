package vowelCount;

import java.util.Scanner;
import java.util.ArrayList;

public class VowelCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a sentence:");
		String sentence = sc.nextLine();
		sc.close();
		
		ArrayList<Integer> VowelCount = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			VowelCount.add(0);
		}
		
		for(int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if(ch == 'a') {
				VowelCount.set(0, VowelCount.get(0) + 1);
			} else if(ch == 'e') {
				VowelCount.set(1, VowelCount.get(1) + 1);
			} else if(ch == 'i') {
				VowelCount.set(2, VowelCount.get(2) + 1);
			} else if (ch == 'o') {
				VowelCount.set(3, VowelCount.get(3) + 1);
			} else if (ch == 'u') {
				VowelCount.set(4, VowelCount.get(4) + 1);
			}
		}
		
		int TotalVowel = 0;
		for(int total : VowelCount) {
			TotalVowel += total;
		}
		
		System.out.printf("[('u', %d), ('o', %d), ('i', %d), ('e', %d), ('a', %d)]",
				VowelCount.get(4),
				VowelCount.get(3),
				VowelCount.get(2),
				VowelCount.get(1),
				VowelCount.get(0));
		System.out.println();
		System.out.printf("There are %d vowels in this sentence", TotalVowel);
	}

}
