package exercise1;

public class MP3 extends Item {

	private int bitrate;

	public MP3(int bitrate, String name) {
		super(name);
		this.bitrate = bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public int getBitrate() {
		return this.bitrate;
	}
}