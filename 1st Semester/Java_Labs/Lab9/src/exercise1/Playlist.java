package exercise1;

import java.util.*;

public class Playlist{

	private String name;
	private Set<Song> songs;

	public Playlist(String name) {
		this.name = name;
		this.songs = new LinkedHashSet<>();
	}

	public String getName() {
		return this.name;
	}

	public List<Song> getSongs() {
		return new ArrayList<Song>(this.songs);
	}

	public int getTotalDuration() {
		int sum = 0;

		for (Song s : this.songs) {
			sum += s.getDuration();
		}

		return sum;
	}

	public int getNumberOfSongs() {
		return this.songs.size();
	}

	public void add(Song s) {
		this.songs.add(s);
	}

	public void play() {
		System.out.println("Playing list '" + this.name + "' (total running time: "
				+ Song.formatDuration(this.getTotalDuration()) + ")");

		for (Song s : this.songs) {
			s.play();
		}
	}
	
	public List<Song> sort(PlaylistSorter sort_object) {
		return sort_object.sort(getSongs());
		
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
