package exercise1;

import java.util.*;

public class Shuffle implements PlaylistSorter {
	
	public Shuffle() {}

	@Override
	public List<Song> sort(List<Song> sort_type) {
		Collections.shuffle(sort_type);
		return sort_type;
	}

	
	
	

}
