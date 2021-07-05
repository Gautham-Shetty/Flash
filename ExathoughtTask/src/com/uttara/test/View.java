package com.uttara.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class View {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String input = "";
		int a = 0;
		String path = "";
		while (a <= 3) {
			System.out.println("Enter 1 to write a sentence to pdf file");
			System.out.println("Enter 2 read contents from pdf file");
			System.out.println("Enter 3 get the occurance of each word in a file");
			System.out.println("Enter 4 to exit application");
			a = sc2.nextInt();
			
			switch (a)

			{

			case 1:
				System.out.println("Enter the sentence you want store to a file");
				input = sc.nextLine();
				System.out.println("Enter the path of file");
				path = sc.nextLine();

				boolean valid = ValidationClass.validate(input);

				if (valid == true) {
					boolean result = AddToFile.write(input,path);
					if (result == true) {
						System.out.println("Sentence wriiten to file successfully");
					} else {
						System.out.println("Sentence cannot written to file successfully");
					}

				} else if (valid == false) {
					System.out.println("Please give proper inputs... Cannot have blank space");
				}
				break;
			case 2:
				System.out.println("Enter file path you want to read");
				String pathname = sc1.nextLine();
				if (ValidationClass.validate(pathname) == false) {
					System.out.println("Enter proper file path");
					break;
				}
				else
				{	
				AddToFile.read(pathname);
				}
				break;
			case 3:
				System.out.println("Enter file path you want to read");
				pathname = sc1.nextLine();
				if (ValidationClass.validate(pathname) == false) {
					System.out.println("Enter proper file path");
					break;
				}
				else
				{
				Map<String, Integer> map = AddToFile.occuranceWord(pathname);
				if (map == null) {
					System.out.println("Some error occured");
				} else {
					Set<Entry<String, Integer>> set = map.entrySet();
					for (Entry e : set) {
						System.out.println(e.getKey() + "=" + e.getValue());
					}
				}
				}
				break;
			
			
		     default :System.out.println("Tata bye bye...");
	                   System.exit(0);		
				

			}

		}
	}
}
