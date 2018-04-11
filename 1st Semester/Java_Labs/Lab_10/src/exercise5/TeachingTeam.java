package exercise5;

import java.util.*;

public class TeachingTeam {
	
	private String course;
	private List <Teacher> teachers;
	
	public TeachingTeam(String course) {
		this.course = course;
		this.teachers = new ArrayList<Teacher>();
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public List <Teacher> getteacher(){
		return this.teachers;
	}
	
	public void add(Teacher t) {
		this.teachers.add(t);
	}
	
	@Override
	public String toString() {
		String all_teachers=null;
		
		for(Teacher t : this.teachers) {
			all_teachers += "\n"+t;
		}
		
		return this.course+all_teachers;
	}
}
