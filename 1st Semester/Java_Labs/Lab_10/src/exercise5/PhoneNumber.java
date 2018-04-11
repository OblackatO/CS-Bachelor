package exercise5;

public class PhoneNumber {
	
	private int countryPrefix;
	private int number;
	private int extension;
	
	public PhoneNumber(int countryPrefix, int number, int extension) {
		this.countryPrefix = countryPrefix;
		this.number = number;
		this.extension = extension;
	}

	public int getCountryPrefix() {
		return countryPrefix;
	}

	public int getNumber() {
		return number;
	}

	public int getExtension() {
		return extension;
	}
	
	@Override
	public String toString() {
		return this.countryPrefix + ":" + this.number + ":" + this.extension;
	}
}
