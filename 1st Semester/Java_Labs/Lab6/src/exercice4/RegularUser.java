package exercice4;

public class RegularUser extends Profile {
	
	private int [] friends = new int[5000]; // if user gets more than 5k friends, he's prompted to create a page
	private int friends_count = 0;
	private String sex;
	private String age;
	
	RegularUser(int id, String name, String sex, String age) {
		super(id, name);
		this.sex = sex;
		this.age = age;
	}
	
	
	public void add_friend(Friend regular_friend) {
		if(this.friends_count < 5000) {
			this.friends[this.friends_count] = regular_friend.get_friend_id();
			QuickSort();
			System.out.println("Sucessfully added friend:"+regular_friend.get_added_friend());
		}else {
			System.out.println("Limit of friends reached, please create a fb page.");
		}
	}
	
	public void show_all_posts(Friend friend) {
		if(search(friend.get_friend_id())) {
			for(int ti=0; ti <= 999; ti++) {
				if(get_all_posts()[ti] != null) {
					System.out.println(get_all_posts()[ti].get_post_info());
				}
			}
		}else {
			System.out.println("You are not allowed to view this page.");
		}
	}
	
	private void QuickSort() {
        // check for empty or null array
        if (this.friends==null || this.friends.length==0){
            return;
        }
        int number = this.friends.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = this.friends[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (this.friends[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list, note that the right list goes from right to left.
            while (this.friends[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = this.friends[i];
        this.friends[i] = this.friends[j];
        this.friends[j] = temp;
    }
    
    private boolean search(int id) {
    		
    		int min = 0;
    		int max = this.friends.length-1;
    		int pivot;
    		
    		while(min <= max) {
        		pivot = (min+max)/2;
    			
        		if(this.friends[pivot] ==id) {
        			return true;
    			}else if(this.friends[pivot]>id) { 
    				max = pivot-1;
    			}else if(this.friends[pivot]<id) {
    				min = pivot+1;
    			}
    		}
    		return false;
	}
    
    @Override 
    public String toString() {
    		return "\n+"+"Sex:"+this.sex+"  Age:"+this.age;
    }
}
