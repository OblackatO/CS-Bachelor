package exercise1;

import java.util.*;

public class PlayCounterSorter implements PlaylistSorter {
	
	public PlayCounterSorter(){}
	
	@Override
	public List<Song> sort(List<Song> list_to_change) {
		Collections.sort(list_to_change);
		return list_to_change;
	}
}
