package exercice4;

public abstract class Account {
	
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
		
	protected void Deposit(int dp_quantity) {
		this.balance += dp_quantity;
	}
	
	protected int Get_balance() {
		return this.balance;
	}

	
	public abstract int Withdraw(int wd_quantity);
}





