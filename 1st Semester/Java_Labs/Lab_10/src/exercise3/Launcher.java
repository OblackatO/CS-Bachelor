package exercise3;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Launcher {

	public static void main(String[] args) throws IOException {
			
		try(FileInputStream in_stream = new FileInputStream("file2.txt");
			Multiple_Output outputs_object = new Multiple_Output(
				    
			    			System.out,
			    			new GZIPOutputStream(new FileOutputStream("gzipped_file.gzip")),
			    			new FileOutputStream("normal_file.txt"))
			    		
			) {
			    
			int b;
			while((b = in_stream.read()) != -1) {
				
				outputs_object.write(b);
			}
		}
	}
}


