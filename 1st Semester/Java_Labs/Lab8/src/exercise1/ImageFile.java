package exercise1;

public class ImageFile extends Item {

	private int width;
	private int height;

	public ImageFile(String name, int width, int height) {
		super(name);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}