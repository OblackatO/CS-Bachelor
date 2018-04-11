package exercise2;

import java.util.*;

public class Playlist {
	
	private String name;
	private LinkedHashSet<Music> songs;
	private double total_play_list_time=0;
	private Iterator <Music> iterator; 
	
	
	public Playlist(String name) {
		this.name = name;
		this.songs = new LinkedHashSet<Music>();
		this.iterator = this.songs.iterator();
	}
	
	public void add_song(Music music) {
		
		/* Got Exception in thread "main" java.util.ConcurrentModificationException
		 * If I did not use iterator.remove() on line 30
		 * */
		
		/*Simpler way to do this 
		 * public void add_song(Music music) { 
		 * if(!songs.add(music)){
			System.out.println("Music already in playlist"); 
			}
		}
		
			Because add method returns false for an hashset if it has already that item
		 * 
		 */
		
		if(this.iterator.hasNext()) {
			while(this.iterator.hasNext()) {
				if(this.iterator.next().equals(music)) {
					System.out.println("Music already in playlist");
				}else {
					this.iterator.remove();
					System.out.println("\n"+"Successfully added:"+music);
					this.songs.add(music);
				}
			}
		}else{
			System.out.println("\n"+"Successfully added:"+music);
			this.songs.add(music);
		}
	}
	
	public double Get_playlist_time() {
		
		for(Music musicc : this.songs) {
			this.total_play_list_time += musicc.getDuration();
		}
		return this.total_play_list_time;
	}
	
	public void play_all() {
		this.iterator = this.songs.iterator();
		for(Music music : this.songs) 
			System.out.println("\n"+"Playing:"+music);
	}
	
	public String Get_name() {
		return this.name;
	}
	

}
