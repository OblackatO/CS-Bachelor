package lu.uni.helloworld;

public class Swapping_contents {

	public static void main(String[] args) {
		int a=3,b=4,temp;
		temp = a;
		System.out.println(temp);
		a = b;
		System.out.println(a);
		b = temp;
		System.out.println(b);
		//Reason why it does not work with the other resolution : 
		//if we have a=b , b=a, a is going to take the value of b, finally if we say 
		// that b=a is the same as saying b=b ,that's why we need to transfer the value of a to temp
		

	}

}
