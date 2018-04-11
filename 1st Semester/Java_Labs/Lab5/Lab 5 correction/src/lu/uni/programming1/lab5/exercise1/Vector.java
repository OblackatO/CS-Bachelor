package lu.uni.programming1.lab5.exercise1;

import java.util.Arrays;
import java.util.Random;

public class Vector {

	static Random generator = new Random(System.currentTimeMillis());

	double[] values;

	public Vector(int dimension) {
		this.values = new double[dimension];
	}

	public void randomFill(int minimum, int maximum) {
		for (int i = 0; i < this.getDimension(); i++) {
			this.values[i] = generator.nextDouble() * (maximum - minimum) + minimum;
		}
	}

	public int getDimension() {
		return this.values.length;
	}

	public double getElement(int index) {
		index = Math.min(Math.max(index, 0), this.getDimension() - 1);
		return this.values[index];
	}

	public void setElement(int index, double newValue) {
		if (index >= 0 && index < this.getDimension()) {
			this.values[index] = newValue;
		}
	}

	public double getNorm() {
		double squareSum = 0;

		for (double coordinate : this.values) {
			squareSum += Math.pow(coordinate, 2);
		}

		return Math.sqrt(squareSum);
	}

	public Vector add(Vector v) {
		if (this.getDimension() != v.getDimension()) {
			return null;
		}

		Vector sum = new Vector(this.getDimension());

		for (int i = 0; i < sum.getDimension(); i++) {
			sum.setElement(i, this.getElement(i) + v.getElement(i));
		}

		return sum;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.values).replace("[", "(").replace("]", ")");
	}
}