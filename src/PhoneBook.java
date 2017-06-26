import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

	private String menu = "Please select an option:\n"
			+ "1. Add new entries \n"
			+ "2. Search by First Name \n"
			+ "3. Search by Last Name \n"
			+ "4. Search by Full Name \n"
			+ "5. Search by Telephone Number \n"
			+ "6. Search by City \n"
			+ "7. Search by State \n"
			+ "8. Delete a Record \n"
			+ "9. Update a Record \n"
			+ "10. Show All Records Alphabetically by First Name \n"
			+ "11. Exit Phonebook";
	private Person[] personArray = new Person[0];

	public PhoneBook(){
	}

	public void startPhoneBook(){
		Scanner sc = new Scanner(System.in);
		System.out.println(menu);
		int option = sc.nextInt();
		sc.nextLine();
		

		do {
			switch(option){
			case 1: 
				System.out.println("Please enter contact information for new phonebook entry: ");
				String newEntry = sc.nextLine();
				String[] temp = splitInput(newEntry);
				Address address = new Address(removeStartSpace(temp[1]), removeStartSpace(temp[2]), removeStartSpace(temp[3]), removeStartSpace(temp[4]));
				Person person = new Person(temp[0], assignFirstName(temp), assignMiddleName(temp), assignLastName(temp), 
						address, removeStartSpace(temp[5]));
				addNewEntry(person);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 2: 
				System.out.println("Please enter a first name: ");
				String firstName = sc.nextLine();
				getEntriesByFirstName(firstName);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 3: 
				System.out.println("Please enter a last name: ");
				String lastName = sc.nextLine();
				getEntriesByLastName(lastName);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 4:
				System.out.println("Please enter a full name: ");
				String fullName = sc.nextLine();
				getEntriesByFullName(fullName);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 5: 
				System.out.println("Please enter a phone number without special characters: ");
				String telephone = sc.nextLine();
				getEntriesByTelephone(telephone);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 6:
				System.out.println("Please enter a city: ");
				String city = sc.nextLine();
				getEntriesByCity(city);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 7:
				System.out.println("Please enter a two-letter state abbreviation: ");
				String state = sc.nextLine();
				getEntriesByState(state.toUpperCase());
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 8:
				System.out.println("Please enter phone number you would like to delete: ");
				String delete = sc.nextLine();
				deleteEntry(delete);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 9:
				System.out.println("Please enter phone number for the entry you would like to modify: ");
				String modify = sc.nextLine();
				updateEntry(modify);
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			case 10:
				listAll();
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();
				break;
			default: 
				System.out.println("Invalid response.");
				System.out.println(menu);
				option = sc.nextInt();
				sc.nextLine();	
			} 

		} while(option !=11);
		System.out.println("Goodbye!");
		//sc.close();
	}
	
	//Takes a string first name and compares it to each person's first name. If the first names match, the method
	//prints out all data for that person
	public void getEntriesByFirstName(String firstName){
		for (int i = 0; i < personArray.length; i++){
			if (firstName.equals(personArray[i].getFirstName())){
				System.out.println(personArray[i].toString());
			}
		}
	}

	//Takes a string last name and compares it to each person's last name. If the last names match, the method
	//prints out all data for that person
	public void getEntriesByLastName(String lastName){
		for (int i = 0; i < personArray.length; i++){
			if (lastName.equals(personArray[i].getLastName())){
				System.out.println(personArray[i].toString());
			}
		}
	}
	
	//Takes a string first and last name and compares it to each person's first and last name. If the names match, the method
	//prints out all data for that person
	public void getEntriesByFullName(String fullName){
		for (int i = 0; i < personArray.length; i++){
			if (fullName.equalsIgnoreCase(personArray[i].getFullName())){
				System.out.println(personArray[i].toString());
			}
		}
	}
	
	//Takes a string telephone number and compares it to each person's telephone number. If the numbers match, the method
	//prints out all data for that person
	public void getEntriesByTelephone(String telephone){
		for (int i = 0; i < personArray.length; i++){
			if (telephone.equals(personArray[i].getTelephone())){
				System.out.println(personArray[i].toString());
			}
		}
}

	public void addNewEntry(Person person){
		personArray = addOneElement(personArray, person);
	}

	public Person[] addOneElement(Person[] input, Person newPerson){
		Person[] newArray = new Person[input.length+1];

		for (int i = 0; i < input.length; i++){
			newArray[i] = input[i];
		}
		newArray[newArray.length-1] = newPerson;
		return newArray;

	}
	
	public String[] splitInput(String str){
		String[] stringArray = str.split(",");
		return stringArray;
	}

	public String assignFirstName(String[] str){
		String[] stringArray = str[0].split(" ");
		String firstName = stringArray[0];
		return firstName;
	}

	public String assignLastName(String[] str){
		String[] stringArray = str[0].split(" ");
		String lastName;
		if (stringArray.length == 2){
			lastName = stringArray[1];
		}
		else if (stringArray.length == 3) {
			lastName = stringArray[2];
		}
		else {
			lastName = stringArray[3];
		}
		return lastName;
	}

	public String assignMiddleName(String[] str){
		String[] stringArray = str[0].split(" ");
		String middleName;
		if (stringArray.length == 2){
			middleName = "";
		}
		else if (stringArray.length == 3) {
			middleName = stringArray[1];
		}
		else {
			middleName = stringArray[1] + " " + stringArray[2];
		}
		return middleName;
	}
	
//	Update a record for a given telephone number
//	Show all records in asc order

	public void getEntriesByCity(String city){
		for (int i = 0; i < personArray.length; i++){
			if (city.equals(personArray[i].getAddress().getCity())){
				System.out.println(personArray[i].toString());
			}
		}
	}
	
	public void getEntriesByState(String state){
		for (int i = 0; i < personArray.length; i++){
			if (state.equals(personArray[i].getAddress().getState())){
				System.out.println(personArray[i].toString());
			}
		}
	}
	
	public void deleteEntry(String telephone){
		Person[] newArray = new Person[0];
		
		for (int i = 0; i < newArray.length; i++){
			if (personArray[i].getTelephone() != telephone){
				newArray = addOneElement(newArray, personArray[i]);
			}
		}
		personArray = newArray;
	}
	
	public static String removeStartSpace(String str){
		String result = "";
		if (str.charAt(0) == ' '){
			for (int i = 1; i < str.length(); i++){
					result += str.charAt(i)+ "";
				}
			}
		else {
			result = str;
		}
			return result;
		}
	
	public void updateEntry(String telephone){
		Scanner scanner = new Scanner(System.in);
		String updateMenu = ("Please select which piece of information you are wanting to update: \n"
				+ "1. First Name \n"
				+ "2. Middle Name(s) \n"
				+ "3. Last Name \n"
				+ "4. Telephone Number \n"
				+ "5. Street Address \n"
				+ "6. City \n"
				+ "7. State \n"
				+ "8. Zip Code \n"
				+ "9. Back");
		
		System.out.println(updateMenu);
		int selection = scanner.nextInt();
		scanner.nextLine();
		
		do {
			switch(selection){
			case 1: 
				System.out.println("Please enter new first name: ");
				String newFirst = scanner.nextLine();
				personArray[getPersonI(telephone)].setFirstName(newFirst);
				updateFullName(telephone);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 2: 
				System.out.println("Please enter new middle name: ");
				String newMiddle = scanner.nextLine();
				personArray[getPersonI(telephone)].setMiddleName1(newMiddle);
				updateFullName(telephone);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 3: 
				System.out.println("Please enter new last name: ");
				String newLast = scanner.nextLine();
				personArray[getPersonI(telephone)].setLastName(newLast);
				updateFullName(telephone);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 4:
				System.out.println("Please enter new telephone number: ");
				String newTelephone = scanner.nextLine();
				personArray[getPersonI(telephone)].setTelephone(newTelephone);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 5: 
				System.out.println("Please enter new street address: ");
				String newStreetAddress = scanner.nextLine();
				personArray[getPersonI(telephone)].getAddress().setStreetAddress(newStreetAddress);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 6:
				System.out.println("Please enter new city: ");
				String newCity = scanner.nextLine();
				personArray[getPersonI(telephone)].getAddress().setCity(newCity);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 7:
				System.out.println("Please enter new two-character state abbreviation: ");
				String newState = scanner.nextLine();
				personArray[getPersonI(telephone)].getAddress().setState(newState);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			case 8:
				System.out.println("Please enter new zip code: ");
				String newZip = scanner.nextLine();
				personArray[getPersonI(telephone)].getAddress().setZip(newZip);
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();
				break;
			default: 
				System.out.println("Invalid response.");
				System.out.println(updateMenu);
				selection = scanner.nextInt();
				scanner.nextLine();	
			} 

		} while(selection !=9);
		//scanner.close();
	}
	
	public int getPersonI(String telephone){
		int personI = 0;
		for (int i = 0; i < personArray.length; i++){
			if (personArray[i].getTelephone().equals(telephone)){
				personI = i;
			}
		}
		return personI;
	}
	
	public void listAll(){
		//ArrayList<Person> arrayList = new ArrayList<Person>(Arrays.asList(personArray));
		Arrays.sort(personArray, Person.nameComparator);
		for (int i = 0; i < personArray.length; i++){
			System.out.println(personArray[i].toString());
		}
		
	}
	
	public void updateFullName(String telephone){
		if (!personArray[getPersonI(telephone)].getMiddleName().equals("")){
			personArray[getPersonI(telephone)].setFullName(personArray[getPersonI(telephone)].getFirstName() + " " 
		+ personArray[getPersonI(telephone)].getMiddleName() + " " + personArray[getPersonI(telephone)].getLastName());
		}
		else {
			personArray[getPersonI(telephone)].setFullName(personArray[getPersonI(telephone)].getFirstName() + " " 
					+ personArray[getPersonI(telephone)].getLastName());
		}
	}
}
