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
			if (valid){
				createInt();
				System.out.print("Score ");
				System.out.println(score);	
			}
			print();
			char c = input.next().charAt(0);
			
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
				valid = false;
			}
		}	
		
	
		System.out.println("Game Over! ");
	
	}
	
	private static int shiftRight() {
		int i, j = 0;
		int points = 0;
		
		for (j = 2; j >= 0; j--){
			for (i = 0; i < 4; i++){
				if (table[i][j] == table[i][j+1] && table[i][j] != 0){
					points +=table[i][j];
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
								points +=table[i][j];
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
		return points;
	}

	private static int shiftDown() {
		int i, j = 0;
		int points = 0;
		
		for (i = 2; i >= 0; i--){
			for (j = 0; j < 4; j++){
				if (table[i][j] == table[i+1][j] && table[i][j] != 0){
					points +=table[i][j];
					table[i+1][j] *= 2;
					table[i][j] = 0;
				}else if (table[i][j] != 0 && table[i+1][j] == 0){
					int i1 = i+1;
					int j1 = j;

					if (i1 < 3){
						while (table[i1+1][j1]==0 && i1 < 2){
							i1+=1;
						}
						if (i1 == 2 && table[i1+1][j1] == 0){
							i1+=1;
						}
						if (i1 < 3){
							if (table[i][j] == table[i1+1][j1]){
								points +=table[i][j];
								table[i1+1][j1] *= 2;
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
		return points;
	}

	private static int shiftLeft() {
		int i, j = 0;
		int points = 0;
		
		for (j = 1; j < 4; j++){
			for (i = 0; i < 4; i++){
				if (table[i][j] == table[i][j-1] && table[i][j] != 0){
					points +=table[i][j];
					table[i][j-1] *= 2;
					table[i][j] = 0;
				}else if (table[i][j] != 0 && table[i][j-1] == 0){
					int i1 = i;
					int j1 = j-1;

					if (j1 > 0){
						while (table[i1][j1-1]==0 && j1 > 1){
							j1-=1;
						}
						if (j1 == 1 && table[i1][j1-1] == 0){
							j1-=1;
						}
						if (j1 > 0){
							if (table[i][j] == table[i1][j1-1]){
								points +=table[i][j];
								table[i1][j1-1] *= 2;
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
		return points;
	}

	private static int shiftUp() {
		int i, j = 0;
		int points = 0;
		
		for (i = 1; i < 4; i++){
			for (j = 0; j < 4; j++){
				if (table[i][j] == table[i-1][j] && table[i][j] != 0){
					points +=table[i][j];
					table[i-1][j] *= 2;
					table[i][j] = 0;
				}else if (table[i][j] != 0 && table[i-1][j] == 0){
					int i1 = i-1;
					int j1 = j;

					if (i1 > 0){
						while (table[i1-1][j1]==0 && i1 > 1){
							i1-=1;
						}
						if (i1 == 1 && table[i1-1][j1] == 0){
							i1-=1;
						}
						if (i1 > 0){
							if (table[i][j] == table[i1-1][j1]){
								points +=table[i][j];
								table[i1-1][j1] *= 2;
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
		return points;
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
