package lu.uni.programming1.lab5.exercise7;

import java.util.Calendar;

public class StudentID {

	String id;

	public StudentID(String id) {
		this.id = id;
	}

	public String getID() {
		return this.id;
	}

	public int getSemester() {
		return Integer.parseInt(this.id.charAt(0) + "");
	}

	public int getYear() {
		return 2000 + Integer.parseInt(this.id.substring(1, 3));
	}

	public String getChecksum() {
		return this.id.substring(8);
	}

	public boolean checkSemester() {
		return this.getSemester() == 0 || this.getSemester() == 1;
	}

	public boolean checkYear() {
		return this.getYear() >= 2003 && this.getYear() <= Calendar.getInstance().get(Calendar.YEAR);
	}

	public boolean checkCheckSum() {
		int number = Integer.parseInt("1" + this.id.substring(0, 8));
		int rest = number % 97;
		String calculatedChecksum = String.format("%02x", rest);
		return this.getChecksum().toLowerCase().equals(calculatedChecksum.toLowerCase());
	}

	public boolean checkValidity() {
		return this.checkSemester() && this.checkYear() && this.checkCheckSum();
	}
}