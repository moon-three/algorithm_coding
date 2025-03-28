import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int end = N * 2 - 1;
		
		for(int i = 0; i < end; i++) {
			
			if(i < N) {
				
				for(int j = N - i - 1; j > 0; j--) {
					System.out.print(" ");
				}
				
				for(int j = 0; j < i * 2 + 1; j++) {
					System.out.print("*");
				}
				
			} else {
				
				for(int j = 0; j < (i - N + 1); j++) {
					System.out.print(" ");
				}
				
				for(int j = 0; j < end - (2 * (i - N + 1)); j++) {
					System.out.print("*");
				}
				
			}
			
			System.out.println();
		}
		sc.close();
	}
}
