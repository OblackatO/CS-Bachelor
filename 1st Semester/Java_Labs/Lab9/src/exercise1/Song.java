package exercise1;

public class Song implements Comparable <Song>{

	private String title;
	private String artist;
	private int duration;
	private int playCount;

	public Song(String title, String artist, int duration, int playCount) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.playCount = playCount;
	}

	public Song(String title, String artist, int duration) {
		this(title, artist, duration, 0);
	}

	public String getTitle() {
		return this.title;
	}

	public String getArtist() {
		return this.artist;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getPlayCount() {
		return this.playCount;
	}

	public void play() {
		this.playCount++;
		System.out.println("Now playing: " + this);
	}

	public static String formatDuration(int duration) {
		int minutes = duration / 60;
		int seconds = duration % 60;
		return (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
	}
	
	@Override
	public String toString() {
		return String.format("%s by %s [%s] (%d times played)", this.title, this.artist, Song.formatDuration(this.duration),
				this.playCount);
	}
	
	@Override
	public int hashCode() {
		return this.title.hashCode() | this.artist.hashCode() | this.duration;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Song)) {
			return false;
		}

		Song s = (Song) obj;

		return s.getArtist().equals(this.getArtist()) && s.getTitle().equals(this.getTitle())
				&& (s.getDuration() == this.getDuration());
	}
	
	@Override
	public int compareTo(Song song) {
		//descendent order
		if(this.getPlayCount() < song.getPlayCount()) {
			return 1;
		}else if(this.getPlayCount() > song.getPlayCount()) {
			return -1;
		}
		return 0;
	}
}
	
	
