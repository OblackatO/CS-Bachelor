package exercice4;

public class Post {

	private String post_info;
	
	Post(String post_info) {
		this.post_info = post_info;
	}
	
	public String get_post_info() {
		return this.post_info;
	}
	
	@Override
	public String toString() {
		return this.post_info;
	}
}
