package math;

import java.util.Scanner;

public class Sumation {

	public static void main(String[] args) {
		int sum = 0;
		int a;
		
		Scanner input = new Scanner(System.in);
		
		a = 1;
		while(a != 0){
			a = input.nextInt();
			sum += a;
		}
		
		
		System.out.println("Soma = " + (sum));
		
		input.close();
	}

}
