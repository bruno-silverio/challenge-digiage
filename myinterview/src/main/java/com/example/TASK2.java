package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */

public class TASK2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> stringList = new ArrayList<>();

		boolean loop = true;

		while (loop) {

			System.out.println("Enter the list elements separated by commas ',' (Press ENTER to stop): ");

			while (true) { // Store the elements in the stringList
				
				String item = scanner.nextLine();

				// Validar se lista vazia
				if (item.isEmpty()) break;

				// Separar a entrada por vírgulas e adicionar ao array de valores
				String[] listaSemVirgula = item.split(",");
				
				for (String valor : listaSemVirgula) {
					stringList.add(valor.trim()); // trim() remove espaços em branco no início e no fim de cada valor
				}
			}

			System.out.println("\nOriginal list: " + stringList); // Print out format original list 

			removeMiddleElement(stringList);

			System.out.println("\nList without middle element: " + stringList); // Print out new list without middle element

			System.out.println("\nTry again? (Y/N)");
			String op = scanner.nextLine();

			if (op.equalsIgnoreCase("N")) {
				loop = false;
			}

			stringList.clear();
		}
		scanner.close();
	}

	private static List<String> removeMiddleElement(List<String> stringList) {

		// Encontra o elemento central da lista
		int middleElement = stringList.size() / 2;

		// Remove o elemento central da lista
		stringList.remove(middleElement);

		return stringList;
	}
}