package exercise1;

public class Item {

	private String name;

	public Item(String name) {
		this.setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void print(String prefix) {
		System.out.println(String.format("%s%s.%s", prefix, this.name, this.getClass().getSimpleName().toLowerCase()));
	}
}