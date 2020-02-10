package exercise1;

import java.io.*;
import java.util.*;

public class print_carol {

	public static void main(String[] args) throws IOException {
		
		FileReader in_file = null;
		BufferedReader in_buffer = null; 
		
		try {
			in_file = new FileReader("xmas12.txt");
			in_buffer = new BufferedReader(in_file);
			
			String [] separated_words;
			ArrayList <String> previous_gifts = new ArrayList<String>();
			
			String content;
			while((content = in_buffer.readLine()) != null ) {
				separated_words = content.split("	"); // can use \t instead
				System.out.println("On the "+separated_words[0]+" of Christmas,");
				System.out.println("My true love sent me");
				previous_gifts.add(separated_words[1]);
				for(int i = previous_gifts.size()-1; i >=0; i--) {
					System.out.println(previous_gifts.get(i));
				}
				System.out.println();
			}
		
		}catch(IOException e) {
			System.out.println("Something went wrong.");
			System.out.println("Exception details:");
			System.out.println(e);
		}finally {
			
			if(in_file != null) {
				in_file.close();
			}
			
			if(in_buffer != null) {
				in_buffer.close();
			}
		}
	}
}

//The comments are suggestions of the professor during the lab to improve my code.
