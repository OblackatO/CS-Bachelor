package lu.uni.helloworld;

public class Prefix_Postfix {

	public static void main(String[] args) {
		 int i = 0, j, k;
				 i++;
				 System.out.println("i = " + i);
				 ++i;
				 System.out.println("i = " + i);
				 System.out.println("i = " + ++i);

				System.out.println("i = " + i++);

				System.out.println("i = " + i);


				j = i++; System.out.println("i = " + i + ", j = " + j);

				j = ++i; System.out.println("i = " + i + ", j = " + j);


				k = i++ + ++j;

				System.out.println("i = " + i++ + ", j = " + ++j + ", k = " + k++);

				k = ++i + j++;

				System.out.println("i = " + i + ", j = " + j + ", k = " + k);

	}

}
//When using ++ , we always increment the value of the var by one. The main difference between ++i and i++ , is that in 
//i++ the var is processed first and then incremented, and in ++i, the var is incremented and then processed. 