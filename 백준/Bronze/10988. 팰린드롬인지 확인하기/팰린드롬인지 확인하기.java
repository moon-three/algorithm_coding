import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		
		int result = 1;
		
		for(int i = 0; i < S.length() / 2; i++) {
			if(S.charAt(i) != S.charAt(S.length() - i - 1)) {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
