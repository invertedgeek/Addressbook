import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

		
                 System.out.print("  Last Name: ");
                 String surname = myScanner.nextLine();
                
          
                 if (surname.equals("")) {
                	     System.out.println("    Please enter a last name.");
                         System.out.print("  Last Name: ");
                         String lastName = myScanner.nextLine();
                         newPerson.setLastName(lastName);
                 } else {
                         newPerson.setLastName(surname);}
                 
                 
                 
         
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

			
			String lastName = newPerson.getLastName();
			if (lastName.equals("")){
				System.out.println("Contact Not Stored");
			}
			else{
			/** Contact information of one person is stored **/
			list.add(newPerson);
			System.out.println(newPerson.getFirstName() + " " + newPerson.getLastName() + " "
							+ "has been successfully added to the contact list! ");
			}
	}
		
	
	/** This method prints out the contacts inside the list **/
	public void printList() {
		System.out.println("2. Print the list of contact. ");
		for (Person person : list) {
			Collections.sort(list);
			System.out.println(person.toString());
			
		}
	}

	
	/**
	 * This method retrieve the individual(s) contact info. from the list by
	 * prompting user to enter the last name that the contact he/ she is looking for.
	 * If there are more than one same last names in the contact list, it prints out all the contacts with that last name.
	 * If there are no last name matches what the user typed in, it prints a message to let the user know.
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
				System.out.println(person.toString());}
				else if (!lastName2.equalsIgnoreCase(person.getLastName())){
					System.out.println("Contact not found, redirect to the main menu. ");
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
		String answer;
		BufferedReader br = new BufferedReader(new FileReader("kkk.txt"));;
		System.out.println("Do you want to open existing file? (Yes/No)");
		Scanner answer1 = new Scanner(System.in);
		answer = answer1.nextLine();
		if(answer.equalsIgnoreCase("Yes")){
				Scanner myScanner1 = new Scanner(new FileInputStream("kkk.txt"));
		System.out.println("--------------------------------------------------------------");
		while (myScanner1.hasNextLine()) {
			System.out.println(myScanner1.nextLine());
		}}
	
		else if(br.readLine() == null) {
			System.out.println("No contacts are recently stroed, redirecting to the main menu.");
		}
		}
	}

