package Exercice_2;

class Person {
	String name; 
	
	Person(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
}

class BankAccount {
	Person holder;
	double balance;
	
	BankAccount(String holder, int balance) {
		this.holder = new Person(holder);
		if(balance<0) {
			System.out.println("Error. Balance must be greater or equal to 0.");
			System.exit(1);
		}else  {
			this.balance = balance;
		}
	}
		
	void deposit_cache(double amount) {
		if (amount<0) {
			System.out.println("Error. The deposit amount must be positive.");
		}else  {
			balance = balance + amount;
			System.out.println("You deposited:"+amount);
		}
	}
	
	boolean withdraw_cache(int amount) {
		if (amount<0) {
			System.out.println("Error, The withdraw amount must be superior than 0.");
		} else  {
			balance = balance - amount;
			if(balance>0) {
				return true;
			}else if(balance==0) {
				System.out.println("You have 0 euros in your bank account.");
				return true;
			}else {
				System.out.println("You do not have enough money.");
				return false;
			}
			
		}
		return false;
	}
	
	void transfer(BankAccount object_instance, double amount) {
		double result = balance-amount;
		if((result)>=0) {
			object_instance.deposit_cache(amount);
		}else  {
			System.out.println("Not enought funds to make transfer, you lack:"+result*(-1));
			
		}
	}
	
	void printBalance () {
		System.out.println("Your new balance is:"+balance);
	}
	
	
		
}


