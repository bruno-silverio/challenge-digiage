package com.example;

import java.util.Scanner;

/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		System.out.println("TASK1 - Palindrome\n");
		System.out.println("Definition => A palindrome is a word, phrase, number, or other sequence of "
				+ "characters which reads the same backward as forward, such as madam or racecar\n");

		while (loop) {

			System.out.println("Enter a string:");
			String input = scanner.nextLine(); // The variable input contains the characters for analysis

			// If the function return TRUE, then the input is a palindrome
			if (isPalindrome(input)) {
				System.out.println("The string ´" + input + "´ is a palindrome!");
			} 
			// If the function return FALSE, then the input is not a palindrome
			else {
				System.out.println("The string ´" + input + "´ isn't a palindrome!");
			}

			System.out.println("Try again? (Y/N)");
			String op = scanner.nextLine();
			
			// If the user wants to stop the application, they will press 'N' or 'n' (no).
			if (op.equalsIgnoreCase("N")) {
				loop = false;
			}
		}
		scanner.close();
	}

	private static boolean isPalindrome(String input) {

		// Fix the string formatting by removing the spaces and converting everything to lowercase.
		String copyInput = input.trim().replaceAll("\\s+", "").toLowerCase();

		// Generate a mirrored copy of the string
		String reverseString = new StringBuilder(copyInput).reverse().toString();

		// Return true or false when comparing the original string with the mirrored one.
		return reverseString.toString().equals(copyInput);
	}
}