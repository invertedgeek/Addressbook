import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** One object of this class stores a list of persons' contact **/
public class List {

	private ArrayList<Person> list = new ArrayList<Person>();
	
	/**
     * Searches to see if there is an existing
     * contact list .txt file on the hard drive.
     * If there is, it loads it and returns to the main.
     * If there isn't, it returns to the main program.
     */
	public void runMenu() {
		
		
	}
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
		if (lastName.equals("")) {
			System.out.println("Contact is not being stored. ");
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
	 * @param person 
	 **/
	public void searchLastName() {
		System.out.println("3. Retrieve contacts by searching last name. ");
		System.out.print(" Last Name: ");
		Scanner myScanner = new Scanner(System.in);
		String lastName2 = myScanner.nextLine();
		
		for (Person person: list)
        {
                if (lastName2.equals(person.getLastName())) 
                {
                        System.out.println(person);
                }
                else {
                	System.out.println("There are no last name matches in the contact list");
                
                }
        }
		System.out.println("-----------------------------");
        System.out.println("Redirecting to the Main Menu");
       

}
	/**Basic UI for the program which prompts users to choose one of the four options provided**/
	public int mainMenu() {
            System.out.println("-----------------------------");
            System.out.println("What do you want to do?");
            System.out.println("  1. Add new person");
            System.out.println("  2. Visualize contact list");
            System.out.println("  3. Search a specific person on the contact list by last name");
            System.out.println("  4. Exit");
            System.out.println();
            System.out.print("Input: ");
        
            Scanner myScanner = new Scanner(System.in);
            int userChoice = myScanner.nextInt();
            System.out.println("-----------------------------");
            return userChoice;
	}


    /**
     * Saves the existing contact list to a .txt file on the hard drive, 
     * then prints a confirmation and a farewell message.
     */
	public void exit() {
		  for (Person person : list) {
			String saving = person.toString();
		try {
			BufferedWriter writer = new BufferedWriter ( new FileWriter(".\\ContactListSaved.txt"));
			writer.write(saving);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}}
		  
		
		System.out.println("------------------");
		System.out.println("Program Terminated, Saved to disk");
		System.out.println("------------------");
	
	}
	}
