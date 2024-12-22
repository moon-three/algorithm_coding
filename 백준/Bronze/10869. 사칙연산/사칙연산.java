import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		int num1 = Integer.parseInt(value.split(" ")[0]);
		int num2 = Integer.parseInt(value.split(" ")[1]);
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		System.out.println(num1 % num2);
		
		sc.close();
	}
}