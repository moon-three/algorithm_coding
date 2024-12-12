import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		long num1 = Integer.parseInt(value.split(" ")[0]);
		long num2 = Integer.parseInt(value.split(" ")[1]);

		long answer = num2 - num1;
		if(answer < 0) answer *= -1;
		
		System.out.println(answer);		
	}
}