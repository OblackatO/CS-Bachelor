package exercice3;

public class Person {
	
	String name, passportNumber;
	
	Person(String name, String passportNumber) {
		this.name = name;
		this.passportNumber = passportNumber;
	}

	public String getName() {
		return name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

}
