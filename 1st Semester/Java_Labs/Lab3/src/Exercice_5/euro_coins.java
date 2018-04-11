package Exercice_5;

public class euro_coins {

	public static void main(String[] args) {
		int result,money_expected=100,iterations=0 ; 
		
		/* I use 3 for loops and increment the value of each coin, till finding the 
		*a combination (if result ==100), the wrong combinations are not taken in 
		*consideration
		**/
		
		for (int coins5=0; coins5<=(money_expected/5);coins5++) {
			for (int coins10=0; coins10<=(money_expected/10);coins10++) {
				for (int coins20=0; coins20<=(money_expected/20);coins20++) {
					result = (5*coins5) + (10*coins10) + (20*coins20);
					if (result == money_expected) {
						System.out.println("(5 coins)x"+coins5+" (10 coins)x"+coins10+" (20 coins)x"+coins20);
						iterations++;
					}
				}
			}
		}
		System.out.println();
		System.out.println("Total possible combinations: "+iterations); //number of total tries

	} 
}
	
