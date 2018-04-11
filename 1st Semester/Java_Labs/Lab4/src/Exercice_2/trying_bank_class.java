package Exercice_2;

//import Exercice_2.BankAccount; //in case package would be different
//import Exercice_2.Person; // in case package would be different

public class trying_bank_class {

	public static void main(String[] args) {
		BankAccount gm_account = new BankAccount("Georges Muller",1000);
		BankAccount js_account = new BankAccount("John Smith",1000);
		
		/**georges muller withdraws + make transfer to john smith 
		 */
		gm_account.withdraw_cache(600);
		gm_account.transfer(js_account, 250);
		
		/**new amount of John Smith + john smith makes withdraw of 500 euros 
		 * John smith tries to make withdraw of 5000, and will get an error
		 * Finally John smith will try to make a transfer to georges muller
		 * but again he hasn't got enough $
		 */
		js_account.printBalance();
		js_account.withdraw_cache(5000);
		js_account.transfer(gm_account, 4500);
		

	}

}
