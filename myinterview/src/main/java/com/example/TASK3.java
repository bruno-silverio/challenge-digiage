package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<String> stringList = new ArrayList<>();
		
		boolean loop = true;

		while (loop) {
						
			System.out.println("Write random strings (Press 0 to stop): "); // Pressione ENTER para digitar a proxima string
			String item = scanner.nextLine();

			while (!item.equalsIgnoreCase("0")) { // Adiciona cada item a lista
				stringList.add(item);
				item = scanner.nextLine();
			}
			
			Set<String> distinctItems = new HashSet<>(stringList); // Com a funcao Set pegamos a quantidade de itens distintos da lista

			System.out.println("There exist " + distinctItems.size() + " distinct items on the list.");

			System.out.println("Try again? (Y/N)");
			String op = scanner.nextLine();
			
			if (op.equalsIgnoreCase("N")) {
				loop = false;
			}
			
			distinctItems.clear();
			stringList.clear();	
		}
		scanner.close();
	}
}
