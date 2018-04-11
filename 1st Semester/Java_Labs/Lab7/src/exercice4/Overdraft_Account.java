package exercice4;

public class Overdraft_Account extends Account{
	
	private int Allowedoverdraft;
	
	public Overdraft_Account(int balance, int overdraft) {
		super(balance);
		this.Allowedoverdraft = overdraft;
	}
	
	public int Withdraw(int wd_quantity){
		
		int balance = Get_balance();
		int result = balance - wd_quantity;
		
		if((result < 0) && (result >= -this.Allowedoverdraft)) {
			System.out.println("Withdraw completed.");
			return result;
		}else if(result > 0 ) {
			System.out.println("Withdraw completed.");
			return result;
		}else {
			System.out.println("No sufficient funds available.");
			return 0;
		}
	}
	
	
	
	
	
	

}
