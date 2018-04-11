package exercise3;

import java.util.*;

public class Permissions {
	
	private boolean read;
	private boolean write;
	private boolean execute;
	private static Random generator = new Random(System.currentTimeMillis());
	
	public void setRead(boolean value) {
		this.read = value ;
	}
	
	public boolean canRead() {
		return this.read;
	}
	
	public boolean canWrite() {
		return this.write;
	}
	
	public void setWrite(boolean value) {
		this.write = value;
	}
	
	public boolean canExecute() {
		return this.execute;
	}
	
	public void setExecute(boolean value) {
		this.execute = value;
	}
	
	public boolean FullPerm() {
		return (this.canWrite() && this.canRead() && this.canExecute());
	}
	
	public void setFullPerm(boolean value) {
		this.read = value;
		this.write = value;
		this.execute = value;
	}
	
	@Override
	public String toString() {
		return "Permissions:"+"\n"+"Reading:"+this.canRead()+"\n"+"Writting:"+this.canWrite()+"\n"+"Execute:"+this.canExecute();
	}
	
	@Override 
	public int hashCode() {
		return generator.nextInt(10000);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Permissions)) {
			return false;
		}
		
		Permissions p = (Permissions) obj;
		
		return (p.canRead() == this.canRead() && p.canWrite() == this.canWrite() && p.canExecute() == this.canExecute());
	}
}

