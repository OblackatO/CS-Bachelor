package exercise2;

import java.text.DecimalFormat;

public class Launcher {

	public static void main(String[] args) {
	
		DecimalFormat df = new DecimalFormat("#.00");
		
		//Creates a couple of musics 
		Music music_1 = new Music("GoldenBerg variations", "Bahr", 48,456);
		Music music_2 = new Music("Tift the gift", "Changed hearts", 3.45,123);
		Music music_3 = new Music("Wu tang Clan", "People Says", 2.45,567);
		//Music music_4 = new Music("Wu tang Clan", "People Says", 2.45,567); uncomment to get exception that obj == obj
		
		//Creating a playlist
		Playlist playlist = new Playlist("Good_vibes");
		
		//Adds musics to playlist and tries to add same music 
		playlist.add_song(music_1);
		playlist.add_song(music_2);
		playlist.add_song(music_3);
		//playlist.add_song(music_4); uncomment to get exception that object == obj
		
		//Gets total time of playlist
		System.out.println();
		System.out.println("Playlist total_time:");
		System.out.println(df.format(playlist.Get_playlist_time())+" minutes");
		
		//Playing track on the playlist
		playlist.play_all();
		
		

	}

}
