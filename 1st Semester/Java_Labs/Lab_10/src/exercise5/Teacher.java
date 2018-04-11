package exercise5;

public class Teacher {

	private String name;
	private String office;
	private PhoneNumber phone;

	public Teacher(String name, String office, PhoneNumber phone) {

		this.name = name;
		this.office = office;
		this.phone = phone;

	}

	public String getName() {
		return name;
	}

	public String getOffice() {
		return office;
	}

	public PhoneNumber getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return this.name + ":"+this.office+":"+this.phone;
	}
}
