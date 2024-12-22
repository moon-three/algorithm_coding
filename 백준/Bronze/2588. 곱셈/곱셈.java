import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int total = num1 * num2;
		
		for(int i = 0; i < 3; i++) {
			int mul = num2 % 10;
			int value = num1 * mul;
			System.out.println(value);
			num2 = num2 / 10;
		}
		System.out.println(total);
		
		sc.close();
	}
}