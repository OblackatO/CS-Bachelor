package Exercice3;

public class byt {

	public static void main(String[] args) {
		byte a;
		a = -129; //eclipse warns me that I'm getting an error
		System.out.println(a);

// After running the code I got an error that a byte cannot be converted 
//to int, because I declared a byte, but 128 is already a int 
//byte range : -128/127 ; if i have -129, the compiler wants to convert
//from a int to byte, because -129 is a int. 
// Conslusion :
//		if value negative overflows: int --> byte
//		if value positive overflows: byte -->int 
	}

}
