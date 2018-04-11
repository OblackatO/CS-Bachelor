package Exercice_9;

public class string_R {

	public static void main(String[] args) {
		String platform = "macOS Sierra";
		String browser = "Safari";
		double zoomLevel = 1.5;
		boolean b = platform.toUpperCase().indexOf("MAC") > -1;
		boolean equals = browser.equals("Safari");
		boolean c = zoomLevel >=1.5;
		if (b && equals && c) {
		// do something
		System.out.println("Good to know.");
		}

	}

}
