package exercice4;

public class Launcher {

	public static void main(String[] args) {
		
		//Creates two fb profiles and one fb page
		RegularUser pedro_profile = new RegularUser(1996, "Pedro Gomes", "M","21");
		RegularUser someone_profile = new RegularUser(1324, "Someone", "M", "123");
		Facebook_page uni_lu = new Facebook_page(4562, "University of Luxembourg.");
		
		
		//Three posts are created for the uni, pedro and someone
		Post post1 = new  Post("Salut ceci est un post sur fb.");
		Post post2 = new Post("Salut, moi c someone.");
		Post post3 = new Post("New building just opened.");
		
		
		/*User Pedro and user someone like the uni fb page
		 * the page prints the total number of likes, after that Uni posts
		 * a new Post.
		 */
		uni_lu.like_button(pedro_profile);
		uni_lu.like_button(someone_profile);
		System.out.println("Total likes:"+uni_lu.total_likes());
		uni_lu.new_post(post3);
		System.out.println();
		
		//Pedro and someone retrieve the posts of Uni
		uni_lu.show_post();
		
		/*Pedro posts a new post and someone user does it as well,someone tries to get Pedros posts
		 * but he's not a friend, Pedro adds someone has friend and someone can than see Pedros posts
		 * note that a friend request is not taken in consideration.
		 */
		
		pedro_profile.new_post(post1);
		someone_profile.new_post(post2);
		
		Friend friend_someone = new Friend(someone_profile);
		
		/*I'l having a stackoverflow problem with the method quicksort() in the RegularUser class 
		 * 
		 */
		pedro_profile.show_all_posts(friend_someone);
		pedro_profile.add_friend(friend_someone);
		pedro_profile.show_all_posts(friend_someone);
		
		
		
		
	}
}
