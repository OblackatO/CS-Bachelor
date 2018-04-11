package exercice3;

public class Airlines {
	
	private Plane [] planes_array;
	private int i;
	private int total_planes;
	private String name;
	
	Airlines(Plane[] planes_array, String name) {
		
		this.planes_array = planes_array;
		this.total_planes = this.planes_array.length;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void less1_plane() {
		this.total_planes--;
	}
	
	public Plane set_plane() {
		
		for(int i=0; i<=planes_array.length-1; i++) {
			if(planes_array[i] != null) {
				Plane temp_plane = planes_array[i]; this.i++; 
				planes_array[i] = null; 
				return temp_plane;
			}
		}
		return null;
	}
}
