package exercise4;

import java.util.*;
import java.io.*;

public class Launcher {

	public static void main(String[] args) {
		
		String directory_in_path=null;
		String directory_out_path=null;
		String file_extension = null;
		List <String>words_to_search = new ArrayList<String>();
		
		if(args.length < 4) {
			System.out.println("Not enough arguments passed.");
		}
		
		for(int i=0; i<=args.length-1; i++) {
			
			if(i==0) {
				File dir = new File(args[i]);
				if(!(dir.isDirectory()) || !(dir.exists())) {
					throw new IllegalArgumentException("Illegal arguments passed to the terminal.");
				}else {
					directory_in_path = args[i];
				}
			}else if(i==1) {
				file_extension = args[i];
			}else if(i==2) {
				for(int i2=2; i2<=args.length-2; i2++) {
					//System.out.println(args[i2]);
					words_to_search.add(args[i2]);
				}
			}else if(i==args.length-1) {
				directory_out_path = args[i];
			}
		}
		
		Java_terminal terminal_object = new Java_terminal(directory_in_path, file_extension, words_to_search,directory_out_path);
		
		for(String s : terminal_object.getWords_to_search()) {
			terminal_object.grep(terminal_object.find(terminal_object.getDirectory_in_path()), s, terminal_object.getDirectory_out_path()); 
		}
	}
}

		
		


