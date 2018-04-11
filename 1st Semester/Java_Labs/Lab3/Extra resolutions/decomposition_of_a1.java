package uni.lu.lab3;


public class decomposition_of_a1 {

	public static void main(String[] args) {
		
		/*
		 * Variable declaration.
		 * 
		 * coins20 - coins 5: store the number of coins (of value 20 - 5) that is being tested in each iteration.
		 * startMoney is used to store the amount of money that we are testing for. That amount is multiplied by 100 to avoid decimals,
		 * but divided by 100 when displayed to the user. startMoney should be handled as a constant.
		 * 
		 * NOTE: currentMoney and "done" is used exclusively in the second solution.
		 * */
		double currentMoney = 100, startMoney = 100;
		int coins20 = 0 , coins10 = 0 , coins5 = 0;
		int iterations = 0;
		boolean done = false;
		
		
		///// First solution
		
		/*
		 * In the first solution I use a method I like to call "force brute".
		 * I try every single coin combination possible, even those who make no sense (like 1 5 cent coin alone, or 5*20 cent + 10*10 cent + 20*5 cent)
		 * but just display and register those who have a combined value = startMoney.
		 * 
		 * 
		 * To avoid too many redundant tries, I'll limit the number of coins used to be between 0 and "(startMoney/value_of_coin)".
		 * There is no need to try for coins20 > 5 in the case when startMoney is just 100 (1 euro)
		 * */
		
		
		for(coins20 = 0 ; coins20 <= (startMoney/20) ; coins20++) {
			for(coins10 = 0 ; coins10 <= (startMoney/10) ; coins10++) {
				for(coins5 = 0 ; coins5 <= (startMoney/5) ; coins5++) {
					//Check for valid combinations
					if( ( (coins20 * 20) + (coins10 * 10) + (coins5 * 5) ) == startMoney ) {	
						System.out.println("With "+ coins20 +" coins of 20 cents, "
								  + coins10 +" coins of 10 cents et "
								  + coins5 + " coins of 5 cents, we have "
								  + startMoney/100 + " euros.");
						iterations++;
					}
					
				}
			}
		}
		
		System.out.println("Number of possibilities: " + iterations);
		
		
		//// End of first solution
		
		System.out.println();
		System.out.println("//////////////////////////////////////////////////////// ");
		System.out.println();
		
		////Second solution
		
		/*
		 * The second solution is way more complicated but has the exact same result as solution one.
		 * The biggest difference between the two is that in solution 2 we don't even try to check for
		 * coin combinations that wouldn't work. ( =/= "force brute")
		 */
		
		// Give all variables their default values before starting second solution.
		coins20 = 0 ;
		coins10 = 0 ;
		coins5 = 0 ;
		iterations = 0;
		currentMoney = startMoney;
		done = false;
		
		while(!done) {

//			for(coins5 = 0 ; currentMoney > 0 ; coins5++) {
//				currentMoney = currentMoney - 5;
//			} 
			// This works fine too, but next line has the same result.
			// NOTE: to use this "for", you need to comment out the next line and uncomment the "if ( currentMoney == 0 )"
			// This "for" just adds a new 5 cent coin and subtracts 5 from currentMoney. It stops doing it before currentMoney becomes 0
			
			// Calculate and record the amount of 5 cent coins needed to get "currentMoney"
			coins5 = (int)currentMoney / 5;
			
			// Display and record current combination
			System.out.println("With "+ coins20 +" coins of 20 cents, "
									  + coins10 +" coins of 10 cents et "
									  + coins5 + " coins of 5 cents, we have "
									  + startMoney/100 + " euros.");
			iterations++;
			
//			if ( currentMoney == 0 ) { currentMoney = startMoney -( (coins10 * 10) + (coins20 * 20) ); }
			//NOTE: this line can stay uncommented even when the "for" from before isn't been used, this line will
			// just be useless and won't do anything that can change the result.
			
			// The following condition structure deals with the 10 and 20 cent coins. It has to be after the display
			//of the first combination to allow the case of only 5 cent coins to happen once.
			
			// If we have reached the max number of 20 cent coins possible (for 1euro it's 5 coins), then leave the structure and stop the loop.
			if( coins20 >= (startMoney/20) ) {
				done = true;
			}
			//If a new 10 cent coin can be added without currentMoney becoming negative, add a 10 cent coin and update currentMoney accordingly.
			else if ( (currentMoney - 10) >= 0 ){
				coins10++;
				currentMoney = currentMoney - 10;
			}
			//If a new 10 cent coin would make currentMoney negative, add a 20 cent coin, change coins10 value to 0 and update currentMoney accordingly.
			else { // if ( (currentMoney - 10) < 0 )  Note: the "if" is unnecessary
				coins20++;
				currentMoney = startMoney - (coins20 * 20);
				coins10 = 0;
			}
			
		}
		
		System.out.println("Number of possibilities: " + iterations);
		
//// End of second solution
		
	}

}
