import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		long result = 1;
		Scanner sc = new Scanner(System.in);
		long num = sc.nextInt();
		
		for(long i = num; i > 0; i--) {
			result *= i;
		}
		
		System.out.println(result);
		
	}
}