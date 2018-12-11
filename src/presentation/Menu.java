package presentation;

import java.util.Scanner;

import data.FileManipulator;

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
	
	public void processChoice(int choice) {
		switch (choice) {
		case 1:
			System.out.println("Please enter the text!");
			userEntry = getString();
			if (userEntry.length() > 0) {
				
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
