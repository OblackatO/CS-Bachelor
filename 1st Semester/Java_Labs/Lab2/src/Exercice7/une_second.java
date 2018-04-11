package Exercice7;

import java.util.Scanner;
import java.text.DecimalFormat;

public class une_second {

	public static void main(String[] args) {
		int h,m,s,format; 
		Scanner scanner = new Scanner(System.in);
		DecimalFormat format_deci = new DecimalFormat("00");
		
		System.out.println("Write 1 for am/pm or 2 for 24h and press enter: ");
		format = scanner.nextInt();
		System.out.println("(>)Enter the hour:(example :12)");
		h = scanner.nextInt();
		
		if (format == 1) {
			if (h>12) {
				System.out.println("(!)Error hour > 12");
				System.exit(1);
			}
		} else  {
			if (h>24) {
				System.out.println("(!)Error hour > 24");
				System.exit(1);
			}
		} 
		
		System.out.println("(>)Enter the minutes:");
		m = scanner.nextInt();
		if (m>59) {
			System.out.println("(!)Error minutes > 59");
			System.exit(1);
			}
		
		System.out.println("(>)Enter the seconds:");
		s = scanner.nextInt();
		scanner.close();
		if (s>59) {
			System.out.println("(!)Error seconds > 59");
			System.exit(1);
			}
		
		if (s==59 && m==59) {
			s = 00;
			m = 00;
			if (h==24 || h==12) {
				h=01;
			System.out.println("The time1 is "+format_deci.format(h)+":"+format_deci.format(m)+":"+format_deci.format(s));
			}else {
				h = h+1;
				System.out.println("The time is "+format_deci.format(h)+":"+format_deci.format(m)+":"+format_deci.format(s));
				}
		
		}else if (s==59) { //elif in python
			s = 00;
			m = m+1;
			System.out.println("The time1 is "+format_deci.format(h)+":"+format_deci.format(m)+":"+format_deci.format(s));
			
				}else  {
					s=s+1;
					System.out.println("The time is "+format_deci.format(h)+":"+format_deci.format(m)+":"+format_deci.format(s));
				
					
		} } } 
		
