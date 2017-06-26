import java.util.Comparator;

public class Person {

	private String firstName;
	private String middleName;
	private String lastName;
	private Address address;
	private String telephone;
	private String fullName;
	
	public Person(){
	}
	
	public Person(String fullName, String firstName, String middleName, String lastName, Address address, String telephone){
		this.fullName = fullName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName1(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone; 
	}
	
	public String toString(){
		if (middleName.equals("")){
			return (this.firstName + " " + this.lastName + ", " + address.toString() + ", " + formatTelephone(telephone));
		}
		else {
			return (this.firstName + " " + this.middleName + " "+ this.lastName + ", " + address.toString() + ", " 
		+ formatTelephone(telephone)); 
		}
	}
	public String formatTelephone(String telephone){
		String areaCode = telephone.substring(0,3);
		String firstThree = telephone.substring(3,6);
		String lastFour = telephone.substring(6,10);
		return "(" + areaCode + ")-" + firstThree + "-" + lastFour;
	}
	
	  public static Comparator<Person> nameComparator = new Comparator<Person>() {               
		    public int compare(Person jc1, Person jc2) {             
		      return (int) (jc1.getFirstName().compareTo(jc2.getFirstName()));         
		    }     
		  };  
		  
}
