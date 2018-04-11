package exercise4;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Java_terminal {

	private ArrayList<File> matched_files;
	private String directory_in_path;
	private String file_extension;
	private List<String> words_to_search;
	private String directory_out_path;

	public Java_terminal(String directory_in_path, String file_extension, List<String> words_to_search2,
			String directory_out_path) {

		this.directory_in_path = directory_in_path;
		this.file_extension = file_extension;
		this.words_to_search = words_to_search2;
		this.directory_out_path = directory_out_path;
		this.matched_files = new ArrayList<File>();
	}

	public ArrayList<File> find(String dir) {
		File file = new File(dir);
		if (file.isDirectory()) {
			//System.out.println("Dir:"+file.getName());
			for (File filex : file.listFiles()) {
				if (filex.isDirectory()) {
					//System.out.println("subdir found:"+filex.getName());
					find(filex.getAbsolutePath());
				} else {
					String file_name = filex.getAbsolutePath();
					if (file_name.substring(file_name.lastIndexOf(".") + 1).equals(this.getFile_extension())
							&& filex.canRead()) {

						//System.out.println(file_name);
						this.matched_files.add(filex);
					}
				}
			}
		}
		return matched_files;
	}

	/*
	 * "If latter is /dev/pts/0" : Did not understand exactly what we have to do
	 * here, with the mock terminal
	 */

	public void grep(ArrayList<File> match_files, String expression, String output_path){

		File output_file = new File(output_path);
		/*
		 * Tried to remove the file if it exists already, did not work
		 * 
		if(output_file.exists()) {
			//System.out.println("path of file:"+output_file.getAbsolutePath());
			System.out.println("Output file already exists, removing it.");
			output_file.delete();
		}
		*/
		
		/*
		 * Also tried to removed file with this approach did not work anyway, also tried to use sudo for both approaches.
		try {
			Files.deleteIfExists(Paths.get(output_file.getAbsolutePath()));
		}catch(IOException e) {
			System.out.println("Not possible to delete the file");
			e.printStackTrace();
		}
		*/
		
		for (File f : match_files) {
			try (FileReader current_file = new FileReader(f);
				BufferedReader in_stream = new BufferedReader(current_file);
			    FileWriter out_file = new FileWriter(output_file,true);
				BufferedWriter out_stream = new BufferedWriter(out_file)){
				
				String current_line;
				String[] words_per_line;
				while ((current_line = in_stream.readLine()) != null) {
					words_per_line = current_line.split(" ");
					for (String word : words_per_line) {
						if (word.equals(expression)) {
							System.out.println("Match found:"+f.getName() + " " + current_line + "\n");
							out_stream.write("Match found! : "+f.getName() + " " + current_line + "\n");
						}
					}
				}

			} catch (IOException e) {
				System.out.println("File not found:"+f.getName());
				
			}
		}
	}

	public String getDirectory_in_path() {
		return directory_in_path;
	}

	public void setDirectory_in_path(String directory_in_path) {
		this.directory_in_path = directory_in_path;
	}

	public String getFile_extension() {
		return this.file_extension;
	}

	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}

	public List<String> getWords_to_search() {
		return words_to_search;
	}

	public String getDirectory_out_path() {
		return directory_out_path;
	}

	public void setDirectory_out_path(String directory_out_path) {
		this.directory_out_path = directory_out_path;
	}
}
