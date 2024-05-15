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
			String input = scanner.nextLine();

			if (isPalindrome(input)) {
				System.out.println("The string ´" + input + "´ is a palindrome!");
			} else {
				System.out.println("The string ´" + input + "´ isn't a palindrome!");
			}

			System.out.println("Try again? (Y/N)");
			String op = scanner.nextLine();

			if (op.equalsIgnoreCase("N")) {
				loop = false;
			}
		}
		System.exit(0);
	}

	private static boolean isPalindrome(String input) {
		
		// Arrumar formatacao da string tirando os espacos e deixando tudo letra minuscula
		String copyInput = input.trim().replaceAll("\\s+", "").toLowerCase();

		// Gerar uma copia espelhada da string
		String reverseString = new StringBuilder(copyInput).reverse().toString();

		// Retorna true ou false na comparacao da string formatada com a espelhada
		return reverseString.toString().equals(copyInput);
	}

}