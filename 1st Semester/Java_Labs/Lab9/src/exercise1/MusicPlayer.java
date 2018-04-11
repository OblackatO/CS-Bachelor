package exercise1;

import java.util.*;

public class MusicPlayer{

	public static void main(String[] args) {

		Playlist notp = new Playlist("Night of the Proms 2016");
		notp.add(new Song("Don't You", "Simple Minds", 261));
		notp.add(new Song("Life Is A Rollercoaster", "Ronan Keating", 237));
		notp.add(new Song("Unwritten", "Natasha Bedingfield", 259, 4));
		notp.add(new Song("The Unforgiven", "Stefanie Heinzmann", 212));
		notp.add(new Song("Music", "John Miles", 352, 10));
		
		// will not be added twice due to use of set
		notp.add(new Song("Music", "John Miles", 352, 10));

		System.out.println("Number of songs in playlist " + notp.getName() + ": " + notp.getNumberOfSongs());

		notp.play();
		
									//!!LAB9 STARTS HERE !!
		//Default Playlist
		System.out.println("\n"+"Default playlist order:");
		System.out.println("====================================");
		List <Song> songs = new ArrayList <Song>(notp.getSongs());
		
		for(Song s : songs) {
			System.out.println(s.getTitle());
		}
		System.out.println("=====================================");
		
		//Shuffling musics on the playlist 
		System.out.println("\n"+"Shuffle playlist order:");
		System.out.println("====================================");
		Shuffle shuffle_object = new Shuffle();
		songs = notp.sort(shuffle_object);
		
		for(Song s : songs) {
			System.out.println(s.getTitle());
		}
		System.out.println("=====================================");
		
		
		/*Order by most played music, in the first should be in "Musics" 
		 * because it has the highest count
		 */
		System.out.println("\n"+"Most played tracks order:");
		System.out.println("====================================");
		PlayCounterSorter counters_object = new PlayCounterSorter();
		songs = notp.sort(counters_object);
		
		for(Song s : songs) {
			System.out.println(s.getTitle());
		}
		System.out.println("=====================================");
		
	}
}
