package exercise1;

import java.util.*;

public class Folder extends Item {

	ArrayList <Item> current_files = new ArrayList<Item>();
	
	public Folder(String name) {
		super(name);
	}
	
	public void Add_File(Item item) {
		current_files.add(item);
	}
	
	public void print(String prefix) {
		Iterator <Item>it = this.current_files.iterator();
		System.out.println(prefix+this.getName()+":");
		while(it.hasNext()) {
			it.next().print(prefix+"\t");
		}
	}
	
}
