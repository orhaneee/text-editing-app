package presentation;

import java.util.Scanner;

import data.FileManipulator;
import domain.Counter;
import domain.IComponent;
import domain.TextSaver;

public class Menu {
	
	private Scanner scanner;
	
	private String userEntry;
	
	private FileManipulator fileManipulator;
	
	private static Menu menu;
	
	private Menu() {}
	
	public static Menu getInstance() {
		if (menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	public void init() {
		scanner = new Scanner(System.in);
		fileManipulator = new FileManipulator();
		
		System.out.println("Welcome to text editing application!\n\n");
		
		while (true) {
			System.out.println("To enter the text from command line please type 1\n"
					+ "or to give it through a file, type 2.\n\n"
					+ "For file choice, the file MUST be in the same folder\n"
					+ "with project!");
			
			processChoice(getInput());
		}
	}
	
	public void showMenu() {
		System.out.println("\n1. Take text input from user and save it into a file\n"
				+ "2. Perform automatic text correction of a given text\n"
				+ "3. Count number of paragraph, line, word, and characters of a given text\n"
				+ "4. Search, list, and count the words containing inputted characters");
	}
	
	public void processMenuChoice(int choice) {
		switch (choice) {
		case 1:
			String input1 = getString();
			IComponent textSaver = new TextSaver();
			textSaver.operation(input1);
			System.out.println("Your text was saved as SavedText.txt");
			break;
		case 2:
			break;
		case 3:
			String input3 = getString();
			IComponent counter = new Counter();
			counter.operation(input3);
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong choice!");
			break;
		}
	}
	
	public void processChoice(int choice) {
		switch (choice) {
		case 1:
			System.out.println("Please enter the text!");
			userEntry = getString();
			if (userEntry.length() > 0) {
				showMenu();
			}
			else {
				System.out.println("You entered nothing!");
			}
			break;
		case 2:
			System.out.println("Please enter the name of the file!");
			String name = getString();
			if (fileManipulator.readFile(name) != null) {
				userEntry = fileManipulator.readFile(name);
				showMenu();
			}
			break;
		}
	}
	
	public String getString() {
		return scanner.nextLine();
	}
	
	public int getInput() {
		int entered = scanner.nextInt();
		scanner.nextLine();
		return entered;
	}
}
