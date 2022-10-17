package com.lockedme;

import java.util.*;
import java.util.Scanner;

public class HandleOptions {

	//The below function handles the main menu options
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				
				int input = sc.nextInt();

				switch (input) {
				//To Display all files in the current directory
				case 1:
					FileOperations.displayAllFiles("main");
					break;
					
				//To go to menu for Add, Delete and Search files options
				case 2:
					HandleOptions.handleFileMenuOptions();
					break;
					
				//To Exit the screen
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
					
				//To handle an invalid option
				default:
					System.out.println("Please select a valid option.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	//The below function handles the secondary menu options
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotPresent("main");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					FileOperations.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							FileOperations.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					FileOperations.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					// Go to Previous menu
					MenuOptions.printMainMenu();
					return;
				case 5:
					// Exit the program
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);					
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
		
		
	}


}
