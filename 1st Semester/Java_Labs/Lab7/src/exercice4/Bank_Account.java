package exercice4;

public class Bank_Account extends Account{
	
	public Bank_Account(int balance) {
		super(balance);
	}
	
	public int Withdraw(int wd_quantity) {
		
		int balance = Get_balance();
		
		if( !(wd_quantity > balance) ) {
			int final_money = balance - wd_quantity; 
			return final_money;
		}else {
			System.out.println("Not enough funds.");
			return 0;
		}
	}
}


