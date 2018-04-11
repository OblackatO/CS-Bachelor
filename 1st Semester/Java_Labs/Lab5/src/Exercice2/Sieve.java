package Exercice2;

import java.util.Arrays;

public class Sieve {

	public static void main(String[] args) {
		int result,p=2;
		boolean[] array_1; 
		array_1 = new boolean[10];
		for(int ti=0;ti<=array_1.length-1;ti++) {
			array_1[ti] = true;
		}
		String nst_array=Arrays.toString(array_1);
		System.out.println(nst_array);
		
		while(Math.pow(p, 2)<100) {
		
			for(int ti1=0;ti1<=array_1.length-1;ti1++) {
				//System.out.println(array_1[ti]);
				result = ti1%2;
				if((ti1>p) && (result==0))  {
					array_1[ti1] = false;
				}
			String nst1_array=Arrays.toString(array_1);
			System.out.println(nst1_array);
			}
	
			for(int ti2=0;ti2<=array_1.length-1;ti2++) {
				if(array_1[ti2]!=false) {
					p=ti2;
				}
			}
			System.out.println("value p:"+p);
		}
		
		for(int ti=0;ti<=array_1.length;ti++) {
			if(array_1[ti]==true) {
				System.out.print(ti+" ");
			}
		}
	}
}