package ie.cct.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ie.cct.controller.Helper;

/**
 * @author Manoel Vitor Nascimento Lopes
 * @college CCT - College
 * @studentNumber 2019286
 * @gitHub https://github.com/manoellvitor/vetClinicCA
 *
 */
public class CLI {

	// Scanner to receive data from the user Keyboard
	Scanner input = new Scanner(System.in);

	// BufferedReader to receive data from the user Keyboard
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// Variable to simple keep the user option
	int option = 0;

	public CLI(Helper helper) {

		welcome(helper);

	}

	// Staff Menu
	private void staffMenu(Helper helper) {
		// Variables of types of STAFF
		String vet = "Veterinarian";
		String nur = "Nurse";
		String trave = "TraineeVet";
		String its = "ITSpecialist";
		String recp = "Receptionist";

		// Output for user
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~STAFF MENU~~~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - List All Staff             <<<");
		System.out.println("     >>>     2 - List Staff by Category     <<<");
		System.out.println("     >>>     3 - List Staff by Name         <<<");
		System.out.println("     >>>     4 - List Staff by Task         <<<");
		System.out.println("     >>>     0 - <<< BACK                   <<<");

		// Try catch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			staffMenu(helper);
		}

		switch (option) {
		case 1:
			helper.listAllStaffMembers();
			staffMenu(helper);
			break;
		case 2:
			// Output for user
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~CATEGORIES~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("     >>>     1 - Veterinarian             <<<");
			System.out.println("     >>>     2 - Nurse                    <<<");
			System.out.println("     >>>     3 - Trainee Vet              <<<");
			System.out.println("     >>>     4 - IT Specialist            <<<");
			System.out.println("     >>>     5 - Receptionist             <<<");
			System.out.println("     >>>     0 - <<< BACK                 <<<");

			// Try catch block to check if the input from user is valid
			// if it is it pass, if not it throws an exception and return to the menu
			try {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.print("|> Enter the Option Number:_ ");
				option = Integer.parseInt(reader.readLine());
			} catch (IOException | NumberFormatException e1) {
				System.out.println("Invalid option, enter a valid NUMBER option!");
				staffMenu(helper);
			}

			switch (option) {
			case 1:
				helper.listStaffByCategory(option, vet);
				staffMenu(helper);
				break;
			case 2:
				helper.listStaffByCategory(option, nur);
				staffMenu(helper);
				break;
			case 3:
				helper.listStaffByCategory(option, trave);
				staffMenu(helper);
				break;
			case 4:
				helper.listStaffByCategory(option, its);
				staffMenu(helper);
				break;
			case 5:
				helper.listStaffByCategory(option, recp);
				staffMenu(helper);
				break;
			case 0:
				staffMenu(helper);
				break;
			default:
				break;
			}
		case 3:
			helper.listStaffByName();
			staffMenu(helper);
			break;
		case 4:
			helper.listByTask();
			staffMenu(helper);
			break;
		case 0:
			secondaryMenu(helper);
			break;
		default:
			System.out.println("Invalid Option, Try Again!");
			staffMenu(helper);
		}
	}

	// Staff Menu
	private void animalMenu(Helper helper) {
		// Variables of kind ANIMALS
		String dog = "Dog";
		String cat = "Cat";
		String bir = "Bird";
		String hor = "Horse";
		String rab = "Rabbit";

		// Output for user
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~ANIMAL MENU~~~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - List All Animals             <<<");
		System.out.println("     >>>     2 - List Animal by Kind          <<<");
		System.out.println("     >>>     3 - List Animal by Name          <<<");
		System.out.println("     >>>     0 - <<< BACK                     <<<");

		// Try catch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			animalMenu(helper);
		}

		switch (option) {
		case 1:
			helper.listAllAnimals();
			animalMenu(helper);
			break;
		case 2:
			// Output for user
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~CATEGORIES~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("     >>>     1 - Dog             <<<");
			System.out.println("     >>>     2 - Cat             <<<");
			System.out.println("     >>>     3 - Bird            <<<");
			System.out.println("     >>>     4 - Horse           <<<");
			System.out.println("     >>>     5 - Rabbit          <<<");
			System.out.println("     >>>     0 - <<< BACK        <<<");

			// Try catch block to check if the input from user is valid
			// if it is it pass, if not it throws an exception and return to the menu
			try {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.print("|> Enter the Option Number:_ ");
				option = Integer.parseInt(reader.readLine());
			} catch (IOException | NumberFormatException e1) {
				System.out.println("Invalid option, enter a valid NUMBER option!");
				animalMenu(helper);
			}
			switch (option) {
			case 1:
				helper.listAnimalByKind(option, dog);
				animalMenu(helper);
				break;
			case 2:
				helper.listAnimalByKind(option, cat);
				animalMenu(helper);
				break;
			case 3:
				helper.listAnimalByKind(option, bir);
				animalMenu(helper);
				break;
			case 4:
				helper.listAnimalByKind(option, hor);
				animalMenu(helper);
				break;
			case 5:
				helper.listAnimalByKind(option, rab);
				animalMenu(helper);
				break;
			default:
				animalMenu(helper);
				break;
			}
		case 3:
			helper.listAnimalByName();
			animalMenu(helper);
			break;
		case 0:
			secondaryMenu(helper);
			break;
		default:
			System.out.println("Invalid Option, Try Again!");
			animalMenu(helper);
		}
	}

	// Treatment Menu
	private void treatmentMenu(Helper helper) {
		// Output for user
		System.out.println("#~~~~~~~~~~~~~~~~~~~~TREATMENT-MENU~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - List All Animals from an Veterinarian <<<");
		System.out.println("     >>>     2 - Treatment Order List by Veterinarian  <<<");
		System.out.println("     >>>     3 - Treat an Animal by Veterinarian       <<<");
		System.out.println("     >>>     0 - <<< BACK                   <<<");

		// Try catch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			treatmentMenu(helper);
		}

		switch (option) {
		case 1:
			helper.listAnimalsFromVet();
			treatmentMenu(helper);
			break;
		case 2:
			helper.listAnimalsFromVet();
			treatmentMenu(helper);
			break;
		case 3:
			helper.treatAnimal();
			treatmentMenu(helper);
			break;
		case 0:
			secondaryMenu(helper);
			break;
		default:
			System.out.println("Invalid option, enter a valid NUMBER option!");
			treatmentMenu(helper);

		}
	}

	// Function to show a nice message to the user
	private void welcome(Helper helper) {
		// Output for user
		System.out.println("#--------------------------------------------------------------------------#");
		System.out.println(" __     __  _____   _____      ____   _       ___   _   _   ___    ____ \n"
				+ " \\ \\   / / | ____| |_   _|    / ___| | |     |_ _| | \\ | | |_ _|  / ___|\n"
				+ "  \\ \\ / /  |  _|     | |     | |     | |      | |  |  \\| |  | |  | |    \n"
				+ "   \\ V /   | |___    | |     | |___  | |___   | |  | |\\  |  | |  | |___ \n"
				+ "    \\_/    |_____|   |_|      \\____| |_____| |___| |_| \\_| |___|  \\____|\n"
				+ "                                                                        ");
		System.out.println("#--------------------------------------------------------------------------#");
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~~~~~~~~~~~~#");
		mainMenu(helper);
	}

	// Main Menu to start the clinic
	private void mainMenu(Helper helper) {
		// Output for user
		System.out.println("     >>>     1 - For Open the Clinic     <<<");
		System.out.println("     >>>     0 - TO EXIT                 <<<");

		// Try catch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			mainMenu(helper);
		}

		switch (option) {
		case 1:
			// Call all the methods to start Staff, animals and assign tasks and animals to
			// be treated
			helper.startAnimals();
			helper.startStaffMembers();
			helper.giveTask();
			helper.assignTreatment();
			secondaryMenu(helper);
			break;
		case 0:
			System.out.println(
					"########  ##    ## ########        ######## ##     ##    ###    ##    ## ##    ##    ##    ##  #######  ##     ## \n"
							+ "##     ##  ##  ##  ##                 ##    ##     ##   ## ##   ###   ## ##   ##      ##  ##  ##     ## ##     ## \n"
							+ "##     ##   ####   ##                 ##    ##     ##  ##   ##  ####  ## ##  ##        ####   ##     ## ##     ## \n"
							+ "########     ##    ######             ##    ######### ##     ## ## ## ## #####          ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##                 ##    ##     ## ######### ##  #### ##  ##         ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##       ###       ##    ##     ## ##     ## ##   ### ##   ##        ##    ##     ## ##     ## \n"
							+ "########     ##    ######## ###       ##    ##     ## ##     ## ##    ## ##    ##       ##     #######   #######  ");
			return;
		default:
			System.out.println("Invalid option, enter a valid NUMBER option!");
			mainMenu(helper);
		}

	}

	// Secondary Menu to separate functionalities
	private void secondaryMenu(Helper helper) {

		// Output for user
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("#     Wellcome, today is:  " + formatter.format(date) + "        #");
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~OPTIONS~~~~~~~~~~~~~~~~~~~~~~~~#");
		System.out.println("     >>>     1 - Staff Menu     <<<");
		System.out.println("     >>>     2 - Animals Menu   <<<");
		System.out.println("     >>>     3 - Treatment Menu <<<");
		System.out.println("     >>>     0 - << EXIT        <<<");

		// Try catch block to check if the input from user is valid
		// if it is it pass, if not it throws an exception and return to the menu
		try {
			System.out.print("|> Enter the Option Number:_ ");
			option = Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e1) {
			System.out.println("Invalid option, enter a valid NUMBER option!");
			mainMenu(helper);
		}

		switch (option) {
		case 1:
			staffMenu(helper);
			break;
		case 2:
			animalMenu(helper);
			break;
		case 3:
			treatmentMenu(helper);
			break;
		case 0:
			System.out.println(
					"########  ##    ## ########        ######## ##     ##    ###    ##    ## ##    ##    ##    ##  #######  ##     ## \n"
							+ "##     ##  ##  ##  ##                 ##    ##     ##   ## ##   ###   ## ##   ##      ##  ##  ##     ## ##     ## \n"
							+ "##     ##   ####   ##                 ##    ##     ##  ##   ##  ####  ## ##  ##        ####   ##     ## ##     ## \n"
							+ "########     ##    ######             ##    ######### ##     ## ## ## ## #####          ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##                 ##    ##     ## ######### ##  #### ##  ##         ##    ##     ## ##     ## \n"
							+ "##     ##    ##    ##       ###       ##    ##     ## ##     ## ##   ### ##   ##        ##    ##     ## ##     ## \n"
							+ "########     ##    ######## ###       ##    ##     ## ##     ## ##    ## ##    ##       ##     #######   #######  ");
			return;
		default:
			System.out.println("Invalid option, enter a valid NUMBER option!");
			secondaryMenu(helper);
		}
	}

}
