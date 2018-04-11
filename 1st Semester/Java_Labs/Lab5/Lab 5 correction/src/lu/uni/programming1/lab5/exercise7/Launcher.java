package lu.uni.programming1.lab5.exercise7;

import java.util.Scanner;

public class Launcher {
	
	public static void main(String[] args) {
		System.out.print("Enter a student ID: ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		scanner.close();

		StudentID studentID = new StudentID(id);

		if (studentID.checkValidity()) {
			System.out.print("Student ID " + studentID.getID() + " is valid. ");

			String firstEnrollmentSemester = studentID.getSemester() == 0 ? "Winter" : "Summer";
			int firstEnrollmentYear = studentID.getYear();

			System.out.println(String.format("First enrollment in %s Semester %d/%d.", firstEnrollmentSemester,
					firstEnrollmentYear, firstEnrollmentYear + 1));

		} else {
			System.err.println("Error: Student ID " + studentID.getID() + " is invalid.");
		}
	}
}