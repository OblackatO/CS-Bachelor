package exercice4;

public class Facebook_page extends Profile {
	 
	private RegularUser[] users_liked = new RegularUser[1000];
	private int current_user=0;
	private int like_counter;
	
	Facebook_page(int id, String name)  {
		super(id, name);
	}
	
	public void like_button(RegularUser user) {
		if(this.current_user <= this.users_liked.length-1) {
			users_liked[this.current_user] = user;
			this.current_user++;
			this.like_counter++;
		}else {
			System.out.println("Page has reached maximum number of likes.");
			System.exit(1);
		}
	}
	
	public int total_likes() {
		return this.like_counter;
	}

}
