package Exercice1;

import java.util.Arrays;
import java.util.Random;

class Vector{
	int[] values;
	
	Vector(int values){
		this.values = new int[values]; //create new values
		
	}
	
	//Must be static, otherwise we got the same random number for each called object
	static Random generator = new Random(System.currentTimeMillis());
	
	/**Set all the coordinates of the vector the to some random number that is
	 * between the bounds specified by the user.
	 */
	void randomFill(int n1, int n2) {
		for(int ti=0;ti<=values.length-1;ti++) {
			int rn = generator.nextInt(n2-n1+1)+n1; // Do not forget this formula for the exam. 
			values[ti]=rn;
		}
	}
	
	//Gets some coordinate of the vector
	int getElement(int index) {
		if(index>values.length-1) {
			System.out.println("Index out of range");
			return 0;
		}
		return values[index];
	}
	
	//Sets some coordinate on the vector
	void setElement(int index,int n1) {
		if(index>values.length-1) {
			System.out.println("Index out of range");
			return;
		}
		values[index] = n1;
		
	}
	
	//Gets the range of the vector
	int getDimension() {
		return values.length;
	}
	
	// Gets Norm of the current object, returns double
	double getNorm() {
		double final_result=0;
		for(int ti=0;ti<=values.length-1;ti++) {
			final_result = ((values[ti])*(values[ti])) + final_result;
		}
		final_result = Math.sqrt(final_result);
		return final_result;
	}
	
	//Adds a vector to the current one, and returns a third vector of the addition.
	Vector add(Vector v) {
		int cv,cvv,final_result; //cv : current value of current vector, cvv:current value of the vector to be added
		if(v.getDimension()!=getDimension()) {
			System.out.println("Vectors are not the same size.");
			return null;
		}else {
			Vector final_vector = new Vector(getDimension());
			for(int ti=0;ti<=values.length-1;ti++) {
				cv = getElement(ti);
				cvv = v.getElement(ti);
				final_result = cv+cvv;
				final_vector.setElement(ti,final_result);
			}
			return final_vector;
		}
		
	}
	
	//Converts from array to string 
	String toString_1() {
		String array_string=Arrays.toString(values);
		array_string = array_string.replace("[","(").replace("]",")");
		return array_string;
	}
	
}


