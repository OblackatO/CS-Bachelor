package exercise3;

import java.util.*;

public class Subject {
	
	private int id;
	private String name;
	static Random generator = new Random(System.currentTimeMillis());
	
	public Subject(String name) {
		this.id = 1001 + name.hashCode()+generator.nextInt(10000);
		//System.out.println("this is the final ID of the user:"+this.id);
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals (Object obj) {
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Subject)) {
			return false;
		}
		
		Subject s = (Subject) obj;
		
		return (s.getId() == this.getId()) && s.getName().equals(this.getName());
	}
	
	@Override
	public String toString() {
		return  "Name:"+this.getName()+" ID:"+this.getId();
	}

}
