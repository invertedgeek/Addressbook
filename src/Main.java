/** A contact list program that stores users' information into the list**/
public class Main {
	public static void main(String args[]) {
			List contact = new List();
			
			int runVariable = 0;

            contact.runMenu();
            while (runVariable == 0) {
                    int userChoice = contact.mainMenu();

                    if (userChoice == 1) 
                            contact.addPerson();
                    else if (userChoice == 2)
                    		contact.printList();
                    else if (userChoice == 3)
                            contact.searchLastName();
                    else if (userChoice == 4) {
                            contact.exit();
                            runVariable = 1;
                    } 
                    else
                            System.out.println("Invalid input.");
		}
	}
}

