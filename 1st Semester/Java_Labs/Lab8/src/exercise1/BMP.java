package exercise1;

public class BMP extends ImageFile {

	private int colordepth;

	public BMP(String name, int width, int height, int colordepth) {
		super(name, width, height);
		this.colordepth = colordepth;
	}

	public void setColordepth(int colordepth) {
		this.colordepth = colordepth;
	}

	public int getColordepth() {
		return this.colordepth;
	}
}