import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** One object of this class stores a list of persons' contact **/
public class List {

	private ArrayList<Person> list = new ArrayList<Person>();

	/**
	 * Prompt user to input First Name, Last Name, Email, Address, Phone Number
	 * and Notes. Read the values and store the values into the contact list.
	 **/
	public void addPerson() {

		System.out.println(" 1. Add a New Person ");
		Person newPerson = new Person();
		Scanner myScanner = new Scanner(System.in);

		System.out.print("  First Name: ");
		String firstName = myScanner.nextLine();
		newPerson.setFirstName(firstName);

		System.out.print("  Last Name : ");
		String lastName = myScanner.nextLine();
		String lastName1 = "";

		/** If last name is blank, prompt user to enter last name again. **/
		if (lastName.equals("")) {
			System.out.print("  Please enter Last Name again. "
					+ "\n  Last Name: ");

			lastName1 = myScanner.nextLine();
			newPerson.setLastName(lastName1);
		} else {
			newPerson.setLastName(lastName);
		}

		/** If last name is blank again, contact is not being stored **/
		if (lastName1.equals("")) {
			System.out
					.println("--------------------------------------------------------------");
			System.out
					.println("Contact is not being stored since you did not input Last Name. ");
		} else {
			System.out.print("  Email     : ");
			String email = myScanner.nextLine();
			newPerson.setEmail(email);

			System.out.print("  Address   : ");
			String address = myScanner.nextLine();
			newPerson.setAddress(address);

			System.out.print("  Phone     : ");
			String phoneNumber = myScanner.nextLine();
			newPerson.setphoneNumber(phoneNumber);
			System.out.print("  Notes     : ");
			String notes = myScanner.nextLine();
			newPerson.setnotes(notes);

			/** Contact information of one person is stored **/
			list.add(newPerson);
			System.out.println(firstName + " " + lastName + lastName1 + " "
					+ "has been successfully added to the contact list! ");
		}

	}

	/** This method prints out the contacts inside the list **/
	public void printList() {
		System.out.println("2. Print the list of contact. ");
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}

	/**
	 * This method retrieve the individual(s) contact info. from the list by
	 * searching last name
	 * 
	 * @param person
	 **/
	public void searchLastName() {
		System.out.println("3. Retrieve contacts by searching last name. ");
		System.out.print(" Last Name: ");
		Scanner myScanner = new Scanner(System.in);
		String lastName2 = myScanner.nextLine();
		System.out.println("--------------------------------------------------------------");

		for (Person person : list) {
			if (lastName2.equalsIgnoreCase(person.getLastName())) {
				System.out.println(person);
			}
			else {
				System.out.println("No contacts found");
	}
		}
	}

	/**
	 * Basic UI for the program which prompts users to choose one of the four
	 * options provided
	 **/
	public int mainMenu() {
		System.out
				.println("--------------------------------------------------------------");
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("  1. Add new person");
		System.out.println("  2. Visualize contact list");
		System.out
				.println("  3. Search a specific person on the contact list by last name");
		System.out.println("  4. Exit");
		System.out.println();
		System.out.print("Input: ");

		Scanner myScanner = new Scanner(System.in);
		int userChoice = myScanner.nextInt();
		System.out.println("----------------------------------------------------------");
		return userChoice;
	}

	/**
	 * Saves the existing contact list to a .txt file on the hard drive, then
	 * prints a confirmation and a farewell message.
	 * 
	 * @throws IOException
	 */
	public void exit() throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(".\\kkk.txt"));
		for (Person p : list) {
			bw.append(p.toString() + "\n");
		}
		bw.close();

		System.out.println("Program Terminated, Saved to disk");
		System.out.println("--------------------------------------------------------------");

	}

	/**
	 * Searches to see if there is an existing contact list .txt file on the
	 * hard drive. If there is, it loads it and returns to the main. If there
	 * isn't, it returns to the main program.
	 * 
	 * @throws IOException
	 */
	public void runMenu() throws IOException {
		System.out
				.println("Searching if there is any contact(s) being stored...");
		Scanner myScanner1 = new Scanner(new FileInputStream("kkk.txt"));
		System.out
				.println("--------------------------------------------------------------");
		while (myScanner1.hasNextLine()) {
			System.out.println(myScanner1.nextLine());
		}

		/**
		 * If the .txt file is empty, give a message to the user and redirect
		 * him/her to the main menu.
		 */
		BufferedReader br = new BufferedReader(new FileReader("kkk.txt"));
		if (br.readLine() == null) {
			System.out
					.println("No contacts are recently stroed, redirecting to the main menu.");
		}
	}

}