package Exercice7;

public class test_uni_verification {

	public static void main(String[] args) {
		studentId student1 = new studentId("017066611B"); //017066611B
		
		System.out.println("Student ID:"+student1.getid());
		System.out.println("Current semester:"+student1.getSemester());
		System.out.println("Current year:"+student1.getYear());
		System.out.println("Checksul:"+student1.getCheckSum());
		System.out.println("The ID is valid:"+student1.Check_validity());

	}

}
