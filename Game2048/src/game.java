import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class game {

	static int table[][] = {{0,0,0,0},
			{0,0,0,0}, 
			{0,0,0,0}, 
			{0,0,0,0}};
	
	public static void main(String[] args) {

		int score = 0;
		boolean valid = true;
		
		Scanner input = new Scanner(System.in); 


		while (hasZeros()){
			if (valid)
				createInt();
			print();
			char c = input.next().charAt(0);
			System.out.println("Key Pressed");
			
			if (c == 'w'){
				score += shiftUp();
				valid = true;
			}else if (c=='a'){
				score += shiftLeft();
				valid = true;
			}else if (c=='s'){
				score += shiftDown();
				valid = true;
			}else if (c=='d'){
				score += shiftRight();
				valid = true;
			}else{
				System.out.println("Entrada inválida! Tente novamente.");
				//valid = false;
			}
		}	
		
	
		System.out.println("Game Over! ");
	
	}
	
	private static int shiftRight() {
		int i, j = 0;
		
		for (j = 2; j >= 0; j--){
			for (i = 0; i < 4; i++){
				if (table[i][j] == table[i][j+1] && table[i][j] != 0){
					table[i][j+1] *= 2;
					table[i][j] = 0;
				}else if (table[i][j] != 0 && table[i][j+1] == 0){
					int i1 = i;
					int j1 = j+1;

					if (j1 < 3){
						while (table[i1][j1+1]==0 && j1 < 2){
							j1+=1;
						}
						if (j1 == 2 && table[i1][j1+1] == 0){
							j1+=1;
						}
						if (j1 < 3){
							if (table[i][j] == table[i1][j1+1]){
								table[i1][j1+1] *= 2;
								table[i][j] = 0;
							}else{
								table[i1][j1] = table[i][j];
								table[i][j] = 0;
							}
						}else{
							table[i1][j1] = table[i][j];
							table[i][j] = 0;
						}			
					}else{
						table[i1][j1] = table[i][j];
						table[i][j]=0;
					}
				}
			}
		}
		
		
		
		return 0;
	}

	private static int shiftDown() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int shiftLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int shiftUp() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void createInt(){
		ArrayList<IntPair> list = new ArrayList<IntPair>();
		Random rand1 = new Random();
		Random rand2 = new Random();
		
		int i=0, j=0;
		
		for (i = 0; i < 4; i++)
			for (j = 0; j < 4; j++)
				if (table[i][j] == 0)
					list.add(new IntPair(i, j));
		
		int pos = -1;

		pos = rand1.nextInt(list.size());
		System.out.println(pos);
		if (list.get(pos) != null){
			i = list.get(pos).geti();
			j = list.get(pos).getj();

			if (rand2.nextFloat() >= 0.67){
				table[i][j] = 4;
			}else{
				table[i][j] = 2;
			}
		}
	}
	
	private static boolean hasZeros(){
		
		int count = 0;
		
		int i, j;
		
		for (i = 0; i < 4; i++)
			for (j = 0; j < 4; j++)
				if (table[i][j] != 0)
					count += 1;
		
		if (count == 16)
			return false;
		
		return true;
		
	}
	
	private static void print(){
		int i,j=0;
		
		for(i = 0; i <4; i++){
			for (j = 0; j < 4; j++){
				System.out.print(table[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
