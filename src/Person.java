/** One object of class Person stores an indivdual's contact info **/

public class Person {
		
	private String firstName;   // firstName is a data member.
	private String lastName;    // lastName is a data member.
	private String email;       // email is a data member.
	private String address;     // address is a data member.
	private String phoneNumber; // phoneNumber is a data member     
	private String notes;       // notes is a data member.
	
	/**Sets the value of firstName to "newFirstName".**/
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;	}

	/**Sets the value of lastName to "newLastName".**/
	public void setLastName(String newLastName) {
		lastName = newLastName;		}

	/**Sets the value of email to "newEmail".**/
	public void setEmail(String newEmail) {
		email = newEmail;	}

	/**Sets the value of address to "newAddress".**/
	public void setAddress(String newAddress) {
		address = newAddress;		}
	
	/**Sets the value of phoneNumber to "newPhoneNumber".**/
	public void setphoneNumber(String newPhoneNumber) {
		phoneNumber = newPhoneNumber;		}
	
	/**Sets the value of notes to "newNotes".**/
	public void setnotes(String newNotes) {
		notes = newNotes;}
	
	/**Return the value of firstName.**/
	public String getFirstName() {
		return firstName;}
	
	/**Returns the value of lastName.**/
	public String getLastName(){
        return lastName;}
	
	/**Returns the value of email.**/
	public String getEmail() {
		return email;}
	
	/**Returns the value of address.**/
	public String getAddress() {
		return address;}
	

	/**Returns the value of phoneNumber.**/
	public String getPhoneNumber() {
		return phoneNumber;}
	
	 /**Returns the value of notes.**/
	public String getNotes() {
		return notes;}
	

	/**Returns a String containing the user's information.**/
		public String toString() {
			return  firstName + " " + lastName + "\n    Street Address: " + address + "\n    Email address: " + email
					+ "\n    Phone number: " + phoneNumber + "\n    Notes: " + notes;
			

		
	}
	
}


