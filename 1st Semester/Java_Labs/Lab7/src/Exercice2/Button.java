package Exercice2;

public abstract class Button {
	
	
	protected static String [] total_products = new String[30]; // total number of products in basket
	protected static int current_product=0;
	protected static double total_price;
	private String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	private void pre_checkout() {
		System.out.println("Total price:"+Button.total_price+"€"+"\n"+"Bought items:");
		total_items();
	}
	
	public String checkout() {
		pre_checkout();
		return "/n"+this.name;
	}
	
	public void total_items() {
		for(String x : Button.total_products) {
			if(x != null) {
				System.out.println(x);
			}
		}
	}
	
}	
