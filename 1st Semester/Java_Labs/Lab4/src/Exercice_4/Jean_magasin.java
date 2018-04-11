package Exercice_4;

class Item {
	double price;
	
	Item(double price) {
		this.price = price;
	}
	
	double getprice() {
		return price;
	}
}

class Shop {
	int localNumberOfGiveaways;
	static int maxNumberOfGiveaways;
	
	Shop(int localNumberofGiveaways) {
		this.localNumberOfGiveaways = localNumberofGiveaways;
		
	}
	
	void buy(Item item) {
		double spent_money,ctw; // ctw == chance to win
		
		System.out.println("Prix du produit acheté"+item.getprice());
		
		if(localNumberOfGiveaways==0) {
			System.out.println("There are not more gifts available in this shop.");
		}
		if(maxNumberOfGiveaways==0) {
			System.out.println("There are no more gifts available in all three shops in Luxembourg.");
		}
		
		spent_money = item.getprice();
		if(spent_money<20) {
			ctw = 0.2;
		}else if((spent_money>=20) && (spent_money<=100)) {
			ctw = 0.5;
		}else if(spent_money>100) {
			ctw = 0.10;
		}
	}
}

/**I did not know how to calculate the probabilities of such a problem 
*it is very frustrating, but I almost never did maths in my life.
*/