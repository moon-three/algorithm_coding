import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = 1;
		int b = 1;
		int result = 0;
		
		if(N == 0) {
			result = 0;
		} else if(N < 3) {
			result = 1;
		} else {
			for(int i = 2; i < N; i++) {	// 2부터
				result = a + b;
				a = b;
				b = result;
			}			
		}
		
		System.out.println(result);
		sc.close();
	}
}