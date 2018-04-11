package exercise7;

import java.util.*;

public class Recipe {
	/*
	A Recipe takes a name as well as a list of ingredients. It 
	shall be possible to print all the ingredients of a recipe with their name, quantity and unit.
	*/
	
	private String name;
	private List<Ingredient> ingredients;
	
	public Recipe(String name) {
		
		this.name = name;
		this.ingredients = new ArrayList <Ingredient>();
	}
	
	public void add_ingredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	public void add_ingredients(List <Ingredient> ingredients) {
		this.ingredients.addAll(ingredients);
	}
	
	public Ingredient get_ingredient_object(Ingredient ingredient) throws IngredientNotFoundException {
		if(!(this.ingredients.contains(ingredient))) {
			throw new IngredientNotFoundException("Ingredient:"+ingredient.getName()+" is not on the list");
		}else {
			for(Ingredient i : this.ingredients) {
				if(i.equals(ingredient)) {
					return i;
				}
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
