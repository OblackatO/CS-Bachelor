package exercise2;

import java.util.*;

public class Music {
	
	private static ArrayList<Integer> all_ids = new ArrayList<Integer>();
	private String title, artist;
	private double count, duration; 
	private int id;
	
	public Music(String title, String artist, double duration, int id) {
		
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		
		/*
		 * Apparently "new Integer(int)" is deprecated since java9 : 
		 * https://stackoverflow.com/questions/47095474/the-constructor-integerint-is-deprecated
		 */
		Integer Int_Obj = Integer.valueOf(id); 
		if(Music.all_ids.contains(Int_Obj)) {
			System.out.println("ID already exists");
			System.exit(1);
		}else {
			Music.all_ids.add(id);
		}
	}

	public double getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public double getDuration()  {
		return this.duration;
	}
	
	@Override
	public String toString() {
		return "\n"+"Title:"+this.title+"\n"+"Artist:"+this.artist+"\n"+"Duration:"+this.duration+"minutes";
	}

	@Override
	public int hashCode(){
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj ){
		boolean flag;
		
		Music music = ( Music )obj;
		if( music == this) {
			flag = true;
			return flag;
		}else {
			return false;
		}
	}
	
	
}
