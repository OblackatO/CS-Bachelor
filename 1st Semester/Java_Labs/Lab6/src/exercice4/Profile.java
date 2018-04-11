package exercice4;

import java.util.Scanner;

public class Profile {
	
	private Post [] all_posts = new Post[1000];
	private int current_post=0;
	private int id;
	private String name;
	
	public Profile(int id, String name) {
		
		this.id = id;
		this.name = name;
	} 
	
	public void new_post(Post post) {
		try {
			this.all_posts[this.current_post] = post;
			this.current_post++;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No more posts can be added");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Delete posts? (Y/N) : ");
			String decision = scanner.next();
			if(decision=="Y") {
				System.out.println("How many posts should be deleted ?:");
				int total_posts = scanner.nextInt();
				delete_posts(total_posts);
				scanner.close();
			}else {
				System.exit(1);
				scanner.close();
			}
		}
	}
	
	public void delete_posts(int number_posts) {
		for(int ti=0; ti <= number_posts; ti++) {
			this.all_posts[this.current_post] = null;
			this.current_post--;
		}
	}
	
	public void show_post() {
		for(int ti=0; ti<=this.all_posts.length-1; ti++) {
			if(this.all_posts[ti] != null) {
				System.out.println("\n"+this.all_posts[ti]);
			}
		}
	}
	
	public int get_id() {
		return this.id;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public Post[] get_all_posts() {
		return this.all_posts;
	}
	
	@Override
	public String toString() {
		return "User name:"+this.name+"\n"+"User ID:"+this.id+"\n"+"Total number of posts:"+this.current_post;
	}
	
	

}
