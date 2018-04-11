package exercice4;

public class Friend {
	
	RegularUser regular_friend;
	
	public Friend(RegularUser regular_friend) {
		this.regular_friend = regular_friend;
	}
	
	public int get_friend_id() {
		return this.regular_friend.get_id();
	}
	
	public String get_added_friend() {
		return this.regular_friend.get_name();
	}
	
}
