package exercise7;

/**
 * @author pedrogomes
 * 
 * 1st java Doc (is there way to link methods and classes in JavaDoc to its location ?)
 * 
 * The class Ingredient(@see Lab9.exercise7.Ingredient) has the following attributes : 
 * 		name
 * 		quantity
 * 		unit
 * 
 * name is the name of the specified  ingredient, quantity its quantity and unit the unit of the 
 * quantity, which can be specified using the enum Units. 
 * 
 * The class Recipe has a List of Ingredients and the user can check if 
 * a recipe has a certain specified ingredient with the (@see  Lab9.exercise7.Recipe#get_ingredient_object()) 
 *
 */

public class Launcher {

	public static void main(String[] args) {
		Ingredient i1 = new Ingredient("Milk", 1, Units.l);
		Ingredient i2 = new Ingredient("Chocolate", 50, Units.g);
		Ingredient i3 = new Ingredient("Eggs", 4, Units.unit);
		
		Recipe chocolate_cake = new Recipe("Chocolate Cake");
		chocolate_cake.add_ingredient(i1);
		chocolate_cake.add_ingredient(i2);
		chocolate_cake.add_ingredient(i3);
		
		
		//Check if got i1
		try {
			chocolate_cake.get_ingredient_object(i1);
		}catch(IngredientNotFoundException e) {
			System.out.println(e);
		}
		
		//create new ingredient and check if it is in the recipe 
		Ingredient i4 = new Ingredient("Sugar",25,Units.g);
		
		try {
			chocolate_cake.get_ingredient_object(i4);
		}catch(IngredientNotFoundException e) {
			System.out.println(e);
		}
			
	}
}

