package exercise1;

public class JPG extends ImageFile {

	private String encoding;

	public JPG(String name, int width, int height, String encoding) {
		super(name, width, height);
		this.encoding = encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getEncoding() {
		return this.encoding;
	}
}