import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String result = "";
		
		for(int i = 0; i < N / 4; i++) {
			result += "long ";
		}
		result += "int";
		
		System.out.println(result);
		sc.close();
	}
}