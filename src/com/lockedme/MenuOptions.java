package com.lockedme;

public class MenuOptions {

	//This method prints the Application and Developer details
	public static void printWelcomeScreen(String appName, String developerName) {
		String companyDetails = String.format("********************************************************\n"
				+ "** Welcome to %s.com. \n" + "** This application was developed by %s.\n"
				+ "********************************************************\n", appName, developerName);
		System.out.println(companyDetails);
		
	}
	
	//This method prints the main menu for the user to navigate
	public static void printMainMenu() {
		String appFunction = "Choose one of the below options :-\n"
				+ "1 - Retrieve all file names in the \"main\" folder\n"
				+ "2- Search, add, or delete files in \"main\" folder.\n"
				+ "3- Exit \n";
		System.out.println(appFunction);
		
	}

	public static void displayFileMenuOptions() {
		String fileMenu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Add a file to \"main\" folder\n" + "2) Delete a file from \"main\" folder\n"
				+ "3) Search for a file from \"main\" folder\n" + "4) Show Previous Menu\n" + "5) Exit program\n";

		System.out.println(fileMenu);
	}

}
