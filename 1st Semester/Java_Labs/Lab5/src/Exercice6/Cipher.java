package Exercice6;
//do not forget to writer decrypter too 
import java.util.Scanner; 

public class Cipher {

	public static void main(String[] args) {
		int cipher_shift=26;
		char current_char,new_char;
		String input_text,encrypted_message="";
		Scanner scanner = new Scanner(System.in);
		
		char[] alphabet =   {'A','B','C','D','E','F','G','H','I'
							 ,'J','K','L','M','N','O','P','Q','R','S'
							 ,'T','U','V','W','X','Y','Z'
							};
		while(cipher_shift==26) {
			System.out.println("Shift of the cipher:");
			cipher_shift = scanner.nextInt();
		}
		scanner.nextLine();
		System.out.println("Plaintext to encrypt:");
		input_text = scanner.nextLine();
		scanner.close();
		input_text = input_text.toUpperCase().replaceAll("[^A-Z]", "");
		
		for(int ti=0;ti<=input_text.length()-1;ti++) {
			current_char = input_text.charAt(ti);
			for(int current_position,ti1=0;ti1<=alphabet.length-1;ti1++) {
				if(current_char==alphabet[ti1]) {
					current_position=ti1+cipher_shift;
					System.out.println(current_position);
					if(current_position>25) {
						new_char = alphabet[current_position-26];
						encrypted_message += new_char;
					}else {
						System.out.println(current_position);
						new_char=alphabet[current_position];
						encrypted_message +=new_char;
					}
				}
			}
		}
		System.out.println(encrypted_message);
	}
}
