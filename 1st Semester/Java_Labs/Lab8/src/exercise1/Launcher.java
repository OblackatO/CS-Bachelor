package exercise1;

public class Launcher {
	
	public static void main(String[] args) {
		
		//Creates a bunch of files and two folder folder
		MP3 mp3_file = new MP3(512, "music");
		Item jpg_file = new JPG("pic1",34,43,"utf-8");
		Item bmp_file = new BMP("pic2",34,43,54);
		Folder folder_kl = new Folder("all_files");
		Folder folder_lk = new Folder("sub_folder");
		
		//Adds files to the folder_kl 
		folder_kl.Add_File(mp3_file);
		folder_kl.Add_File(jpg_file);
		folder_kl.Add_File(bmp_file);
		
		//Adds two files to the folder_lk
		folder_lk.Add_File(jpg_file);
		
		//Adds folder_lk to folder_kl
		folder_kl.Add_File(folder_lk);
		
		//tree method on fodler_kl 
		folder_kl.print("  ");
	}
}


