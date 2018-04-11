package Exercice7;

import java.util.Objects;

class studentId {
	String id;
	String current_year ="2017";
	int current_semester=0;
	
	studentId(String id) {
		this.id = id;
	}
	
	String getid() {
		return id;
	}
	
	int getSemester() {
		char semester_char = id.charAt(0);
		int id_number = Integer.parseInt(semester_char+"");
		return id_number;
	}
	
	String getYear() {
		String semester_string = id.substring(1,3);
		int year = 2000+Integer.parseInt(semester_string);
		String year_final = Integer.toString(year);
		if(!(year>2003)) {
			System.out.println("Invalid year.");
			return null;
		}else {
			return year_final;
		}
	}
		
	
	String getCheckSum() {
		String check_sum = id.substring(id.length()-2,id.length());
		return check_sum;
	}
	
	boolean Check_validity() {
		String first8_digits = "1"+id.substring(0,8);
		int rest = Integer.parseInt(first8_digits)%97;
		String hex_representation = String.format("%02x",rest);
		String rest_string = Integer.toString(rest);
		char rest_char = rest_string.charAt(0);
		String checksum = hex_representation;
		checksum = checksum.toUpperCase();
		boolean valid_checksum = Objects.equals(checksum, getCheckSum());
		boolean valid_year=false,valid_semester=false;
		if(getYear().equals(this.current_year)) {
			valid_year = true;
		}
		if(Objects.equals(getSemester(), this.current_semester)) {
			valid_semester =true;
		}
		if(valid_checksum && valid_year && valid_semester) {
			return true;
		}else {
			return false;
		}
	}
}