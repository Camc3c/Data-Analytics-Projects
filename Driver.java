// Author:  Cameron Chenault

// IT 145 Section X2115

// Assignment: 7-1 Project Two Submission

// 12/10/2023

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // Creating a Scanner Object
    private static Scanner scanner = new Scanner(System.in);
    // Creating a Dog ArrayList
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // create a monkey ArrayList
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();
        // Initialize menu option variable
        String menuOption = "";

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    // While loop that gets user input to display menu
        while (!menuOption.equalsIgnoreCase("q")) {
            // Call display menu method
            displayMenu();
            menuOption = scanner.nextLine();

            // If statement for determining menu choice
            // Runs method to intake a new dog
            if (menuOption.equalsIgnoreCase("1")) {
                intakeNewDog(scanner);
            }
            // Runs method to intake a new monkey
            else if (menuOption.equalsIgnoreCase("2")) {
                intakeNewMonkey(scanner);
            }
            // Runs method to reserve and animal
            else if (menuOption.equalsIgnoreCase("3")) {
                reserveAnimal(scanner);
            }
            // Runs method to list all dogs
            else if (menuOption.equalsIgnoreCase("4")) {
                printAnimals(menuOption);
            }
            // Runs method to list all monkeys
            else if (menuOption.equalsIgnoreCase("5")) {
                printAnimals(menuOption);
            }
            // Runs methood to list all animals that are not reserved
            else if (menuOption.equalsIgnoreCase("6")) {
                printAnimals(menuOption);
            }
            // Runs methood to list all animals that are not reserved
            else if (menuOption.equalsIgnoreCase("q")) {
                System.out.print("\nYou are leaving the application.");
                break;
            }
            // Error message for invalid input
            else {
                System.out.println("Not a valid input. Please enter a valid input.");
            }

        }

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Bo", "Tamarin", "male", "3", "3.7", "10.2", "20.3", "7.5", "06-13-2020", "United States", "in service", false, "United States");
        Monkey monkey2 = new Monkey("Lo", "Guenon", "female", "5", "3.7", "15.8", "27.3", "0.0", "01-22-2018", "United States", "in service", false, "United States");
        Monkey monkey3 = new Monkey("Mo", "Squirrel monkey", "male", "9", "3.7", "5.8", "2.3", "10.9", "11-01-2021", "United States", "in service", false, "United States");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog: dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
            
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        // Get information for new dog

        // Prompt user to enter dogs breed
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();

        // Prompt user to enter dogs gender
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();

        // Prompt user to enter dogs age
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();

        // Prompt user to enter dogs weight
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();

        // Prompt user to enter dogs acquisition date
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        // Prompt user to enter dogs acquisition country
        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        // Prompt user to enter dogs training status
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();

        // Prompt user to enter dogs reserve stataus
        System.out.println("What is the dog's reserved (Y/N)?");
        boolean reserved = scanner.nextBoolean();

        // Prompt user to enter dogs in-service country
        System.out.println("What is the dog's in-service country?");
        String inServiceCountry = scanner.nextLine();

        // Create a new monkey object for the data given
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        
        // Add the newly created dog inform into the dog list
        dogList.add(dog);
        System.out.println("A new dog has been added to the database!");

    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey monkey: monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }
        // Get information for new monkey

        // Prompt user to enter monkeys species
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        // Prompt user to enter monkeys gender
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();

        // Prompt user to enter monkeys age
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();

        // Prompt user to enter monkeys height
        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine();

        // Prompt user to enter monkeys weight
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();

        // Prompt user to enter monkeys body length
        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine();

        // Prompt user to enter monkeys tail length
        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine();

        // Prompt user to enter monkeys acquisition date
        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        // Prompt user to enter monkeys acquisition country
        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        // Prompt user to enter monkeys training status
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();

        // Prompt user to enter monkeys reserve stataus
        System.out.println("What is the monkey's reserved (Y/N)?");
        boolean reserved = scanner.nextBoolean();

        // Prompt user to enter monkeys in-service country
        System.out.println("What is the monkey's in-service country?");
        String inServiceCountry = scanner.nextLine();

        // Create a new monkey object for the data given
        Monkey monkey = new Monkey(name, species, gender, age, height, weight, bodyLength, tailLength, 
                                    acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        
        // Add the newly created monkey inform into the monkey list
        monkeyList.add(monkey);
        System.out.println("A new monkey has been added to the database!");

    }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        // Prompt user to enter the type of animal they want to reserve
        System.out.println("Enter type of Animal: ");
        String animalType = scanner.nextLine();
        // Prompt user to enter the country the monkey was acquired in
        System.out.println("Enter the animals acquistion country: ");
        String country = scanner.nextLine();
        // If statement to determine what type of animal was chocen
        if (animalType.equalsIgnoreCase("Monkey")) {
            System.out.println("Searching for Monkeys in " + country + "...");
            // For loop to find monkeys the in service location match the country entered,
            // and is currently not reserved.
            for (Monkey obj: monkeyList) {
                if (obj.getInServiceLocation().equalsIgnoreCase(country) && obj.getReserved() == false) {
                    obj.setReserved(true);
                    System.out.println("This monkey is now reserved");
                    return;
                }
            }
            // If no monkey is found
            System.out.println("No monkey found in that country.");
        }
        else if (animalType.equalsIgnoreCase("Dog")) {
            System.out.println("Searching for Dogs in " + country + "...");
            // For loop to find monkeys the in service location match the country entered,
            // and is currently not reserved.
            for (Dog obj: dogList) {
                if (obj.getInServiceLocation().equalsIgnoreCase(country) && obj.getReserved() == false) {
                    obj.setReserved(true);
                    System.out.println("This dog is now reserved");
                    return;
                }
            }
            // If no monkey is found
            System.out.println("No dog found in that country.");
        }
        else {
            System.out.println("Animal type not found.");
        }

    }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals(String menuOption) {
        // Print the dog list
        if (menuOption.equals("4")) {
            for (int i = 0; i < dogList.size(); i++) {
                // Print name
                System.out.print("Name: ");
                System.out.print(dogList.get(i).getName());
                System.out.print("\t");
                // Print status
                System.out.print("Status: ");
                System.out.print(dogList.get(i).getTrainingStatus());
                System.out.print("\t");
                // Print acquisition country
                System.out.print("Acquisition Country: ");
                System.out.print(dogList.get(i).getAcquisitionLocation());
                System.out.print("\t");
                // Print reserve status
                System.out.print("Reserve Status: ");
                System.out.print(dogList.get(i).getReserved());
                System.out.print("\t");
                System.out.println();
            }
        }
        // Printing the monkey list
        else if (menuOption.equals("5")) {
            for (int i = 0; i < monkeyList.size(); i++) {
                // Print name
                System.out.print("Name: ");
                System.out.print(monkeyList.get(i).getName());
                System.out.print("\t");
                // Print status
                System.out.print("Status: ");
                System.out.print(monkeyList.get(i).getTrainingStatus());
                System.out.print("\t");
                // Print acquisition country
                System.out.print("Acquisition Country: ");
                System.out.print(monkeyList.get(i).getAcquisitionLocation());
                System.out.print("\t");
                // Print reserve status
                System.out.print("Reserve Status: ");
                System.out.print(monkeyList.get(i).getReserved());
                System.out.print("\t");
                System.out.println();
            }
        }
        // Print Animals that are in service
        else if (menuOption.equals("6")) {
            // For loop that displays dogs that are in service and are not reserved
            for (int i = 0; i < dogList.size(); i++) {
                if (dogList.get(i).getTrainingStatus().equals("in service") && dogList.get(i).getReserved() == false) {
                    // Print name
                    System.out.print("Name: ");
                    System.out.print(dogList.get(i).getName());
                    System.out.print("\t");
                    // Print status
                    System.out.print("Status: ");
                    System.out.print(dogList.get(i).getTrainingStatus());
                    System.out.print("\t");
                    // Print acquisition country
                    System.out.print("Acquisition Country: ");
                    System.out.print(dogList.get(i).getAcquisitionLocation());
                    System.out.print("\t");
                    // Print reserve status
                    System.out.print("Reserve Status: ");
                    System.out.print(dogList.get(i).getReserved());
                    System.out.print("\t");
                    System.out.println();
                }
            }
            // For loop that displays monkeys that are in service and are not reserved
            for (int i = 0; i < monkeyList.size(); i++) {
                if (monkeyList.get(i).getTrainingStatus().equals("in service") && monkeyList.get(i).getReserved() == false) {
                    // Print name
                    System.out.print("Name: ");
                    System.out.print(monkeyList.get(i).getName());
                    System.out.print("\t");
                    // Print status
                    System.out.print("Status: ");
                    System.out.print(monkeyList.get(i).getTrainingStatus());
                    System.out.print("\t");
                    // Print acquisition country
                    System.out.print("Acquisition Country: ");
                    System.out.print(monkeyList.get(i).getAcquisitionLocation());
                    System.out.print("\t");
                    // Print reserve status
                    System.out.print("Reserve Status: ");
                    System.out.print(monkeyList.get(i).getReserved());
                    System.out.print("\t");
                    System.out.println();
                }
            }
        }
    }
}

